package br.com.mentorama.filmeModulo4.service;

import br.com.mentorama.filmeModulo4.entities.Filme;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IFilmeService {

    List<Filme> findAll(String filme);
    ResponseEntity<Filme> findById(Integer id);
    ResponseEntity update (final Filme filme);
    ResponseEntity delete (Integer id);
    ResponseEntity<Integer> add(final Filme filme);
}
