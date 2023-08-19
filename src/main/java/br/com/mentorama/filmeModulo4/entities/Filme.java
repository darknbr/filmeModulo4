package br.com.mentorama.filmeModulo4.entities;

public class Filme {

    private String nome, nomeDoDiretor;
    private Integer id, ano, nota;

    public Filme(String nome, String nomeDoDiretor, Integer id, Integer ano, Integer nota) {
        this.nome = nome;
        this.nomeDoDiretor = nomeDoDiretor;
        this.id = id;
        this.ano = ano;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDoDiretor() {
        return nomeDoDiretor;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAno() {
        return ano;
    }

    public Integer getNota() {
        return nota;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNomeDoDiretor(String nomeDoDiretor) {
        this.nomeDoDiretor = nomeDoDiretor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", nomeDoDiretor='" + nomeDoDiretor + '\'' +
                ", id=" + id +
                ", ano=" + ano +
                ", nota=" + nota +
                '}';
    }
}
