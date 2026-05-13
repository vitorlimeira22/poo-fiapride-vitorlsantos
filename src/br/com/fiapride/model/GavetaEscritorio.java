package br.com.fiapride.model;

public class GavetaEscritorio extends Gaveta {

    private int quantidadeCanetas;

    public GavetaEscritorio(String nome, String identificador,
                            Armario armario, int quantidadeCanetas) {

        super(nome, identificador, armario);
        this.setQuantidadeCanetas(quantidadeCanetas);
    }

    public int getQuantidadeCanetas() {
        return this.quantidadeCanetas;
    }

    private void setQuantidadeCanetas(int quantidadeCanetas) {
        this.quantidadeCanetas = quantidadeCanetas;
    }

    @Override
    public String organizarItens() {
        return "A gaveta de escritório organizou "
                + this.quantidadeCanetas + " canetas.";
    }
}