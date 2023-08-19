package br.com.mentorama.filmeModulo4.service;

import br.com.mentorama.filmeModulo4.entities.Filme;
import br.com.mentorama.filmeModulo4.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class FilmeService implements IFilmeService{

    @Autowired
    private FilmeRepository filmeRepository;

    public List<Filme> findAll(@RequestParam(required = false) String filme){
        if(filme != null){
            return filmeRepository.findAll(filme);
        }
        return filmeRepository.findAll();
    }

    public ResponseEntity<Integer> add(@RequestBody final Filme filme){
        return filmeRepository.add(filme);
    }

    public ResponseEntity update(@RequestBody final Filme filme){
        return filmeRepository  .update(filme);
    }

    public ResponseEntity delete(@PathVariable("id")Integer id){
        return filmeRepository.delete(id);
    }

    public ResponseEntity<Filme> findById(@PathVariable("id") Integer id) {
        return filmeRepository.findById(id);
    }

}
