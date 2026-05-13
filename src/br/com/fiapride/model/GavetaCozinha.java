package br.com.fiapride.model;

public class GavetaCozinha extends Gaveta {

    private int quantidadeTalheres;

    public GavetaCozinha(String nome, String identificador,
                         Armario armario, int quantidadeTalheres) {

        super(nome, identificador, armario);
        this.setQuantidadeTalheres(quantidadeTalheres);
    }

    public int getQuantidadeTalheres() {
        return this.quantidadeTalheres;
    }

    private void setQuantidadeTalheres(int quantidadeTalheres) {
        this.quantidadeTalheres = quantidadeTalheres;
    }

    @Override
    public String organizarItens() {
        return "A gaveta de cozinha organizou "
                + this.quantidadeTalheres + " talheres.";
    }
}