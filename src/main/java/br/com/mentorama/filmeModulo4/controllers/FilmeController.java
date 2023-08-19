package br.com.mentorama.filmeModulo4.controllers;

import br.com.mentorama.filmeModulo4.entities.Filme;
import br.com.mentorama.filmeModulo4.service.IFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private final IFilmeService filmeService;

    public FilmeController(IFilmeService filmeService){
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<Filme> findAll(@RequestParam(required = false) String filme) {
        return (List<Filme>) filmeService.findAll(filme);
    }
    @GetMapping(value = "/id={id}")
    public Filme findById(@PathVariable("id") Integer id) {
        return filmeService.findById(id).getBody();
    }
    @PostMapping
    public ResponseEntity<Integer> novo(@RequestBody final Filme filme) {
        return filmeService.add(filme);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody final Filme filme) {
        return filmeService.update(filme);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        return filmeService.delete(id);
    }

}
