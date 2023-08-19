package br.com.mentorama.filmeModulo4.patterns;

import br.com.mentorama.filmeModulo4.entities.Filme;

public class FilmeBuilder {
    private String nome, nomeDoDiretor;
    private Integer id, ano, nota;

    public FilmeBuilder withNome(String nome){
        this.nome = nome;
        return this;
    }
    public FilmeBuilder withNomeDoDiretor(String nomeDoDiretor){
        this.nomeDoDiretor = nomeDoDiretor;
        return this;
    }
    public FilmeBuilder withId(Integer id){
        this.id = id;
        return this;
    }
    public FilmeBuilder withAno(Integer ano){
        this.ano = ano;
        return this;
    }
    public FilmeBuilder withNota(Integer nota){
        this.nota = nota;
        return this;
    }
    public Filme builder(){
        return new Filme(nome, nomeDoDiretor, id, ano, nota);
    }
}
