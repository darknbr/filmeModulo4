package br.com.mentorama.filmeModulo4.repository;

import br.com.mentorama.filmeModulo4.entities.Filme;
import br.com.mentorama.filmeModulo4.exceptions.FilmeNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class FilmeRepository {

    private final List<Filme> filmes;

    public FilmeRepository(List<Filme> filmes){
        this.filmes = filmes;
    }

    public List<Filme> findAll(){
        return filmes;
    }

    public List<Filme> findAll(@RequestParam(required = false) String filme){
       return filmes.stream()
               .filter(comp -> comp.getNome().contains(filme))
               .collect(Collectors.toList());
    }

    public ResponseEntity<Integer> add(Filme filme){
        if (filme.getId() == null && filme.getNota() != null && filme.getNota() instanceof Integer) {
            if (filme.getNota() >= 1 && filme.getNota() <= 5) {
                //tentei de todas as formas fazer a checagem se o numero digitado foi diferente de inteiro
                //porem mesmo digitando 4.6 no postman quando eu mando imprimir no console do spring
                //ele ja vem convertido para 4, mas eu implementei a logica acima.
                if (!filmeJaRegistrado(filme)) {
                    filme.setId(filmes.size() + 1);
                    filmes.add(filme);
                    return new ResponseEntity<>(filme.getId(), HttpStatus.CREATED);
                } else {
                    // Filme com informações duplicadas encontrado, retornar erro 409 (Conflict)
                    return new ResponseEntity<>(filme.getId(), HttpStatus.CONFLICT);
                }
            }
        }
        // Se a nota for maior que 5 ou menor que 1, aparecerá o erro 406 (Not Acceptable)
        return new ResponseEntity<>(filme.getId(), HttpStatus.NOT_ACCEPTABLE);
    }

    private boolean filmeJaRegistrado(Filme filme) {
        for (Filme registrado : filmes) {
                if (registrado.getAno().equals(filme.getAno()) ||
                        registrado.getNome().equals(filme.getNome()) ||
                        registrado.getNomeDoDiretor().equals(filme.getNomeDoDiretor())) {
                    return true;
                }

        }
        return false;
    }

    public ResponseEntity update(Filme filme){
        filmes.stream()
                .filter(comp -> comp.getId().equals(filme.getId()))
                .forEach(comp -> {
                    comp.setId(filme.getId());
                    comp.setAno(filme.getAno());
                    comp.setNome(filme.getNome());
                    comp.setNota(filme.getNota());
                    comp.setNomeDoDiretor(filme.getNomeDoDiretor());
                });
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity delete(Integer id){
        filmes.removeIf(comp -> comp.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<Filme> findById(Integer id){
        boolean alunoExiste = id >= 0 && id <= filmes.size();
        try {
            if (alunoExiste == false) {
                throw new FilmeNaoEncontradoException();
            }else{
                Filme alunoEncontrado = filmes.stream()
                        .filter(comp -> comp.getId().equals(id))
                        .findFirst()
                        .orElse(null);
                return ResponseEntity.ok(alunoEncontrado);
            }
        }catch (FilmeNaoEncontradoException e){
            throw new FilmeNaoEncontradoException();
        }
    }
}
