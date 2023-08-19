package br.com.mentorama.filmeModulo4.patterns;

import br.com.mentorama.filmeModulo4.entities.Filme;

public class testeMain {
    public static void main(String[] args) {
        Filme filme = new FilmeBuilder()
                .withId(1)
                .withAno(1988)
                .withNome("Danillo Dias de Lima")
                .withNomeDoDiretor("Daniel Dias de Lima")
                .withNota(5)
                .builder();
        System.out.println(filme);
    }
}
