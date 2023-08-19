package br.com.mentorama.filmeModulo4.controllers;

import br.com.mentorama.filmeModulo4.exceptions.FilmeNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {
    @ExceptionHandler({FilmeNaoEncontradoException.class})
    public ResponseEntity<String> handle(final FilmeNaoEncontradoException e){
        return new ResponseEntity<>("Aluno não encontrado", HttpStatus.NOT_FOUND);
    }
}
