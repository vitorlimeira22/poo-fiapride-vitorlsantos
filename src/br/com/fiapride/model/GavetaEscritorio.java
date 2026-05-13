package br.com.fiapride.model;

public class GavetaEscritorio extends Gaveta implements Organizavel {

    private int quantidadeCanetas;

    public GavetaEscritorio(String nome,
                            String identificador,
                            Armario armario,
                            int quantidadeCanetas) {

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
    public String tipoDeOrganizacao() {
        return "Organização de materiais de escritório.";
    }

    @Override
    public void organizar() {
        System.out.println("A gaveta de escritório organizou as canetas.");
    }

    @Override
    public String verificarStatus() {
        return "Gaveta de escritório organizada.";
    }
}