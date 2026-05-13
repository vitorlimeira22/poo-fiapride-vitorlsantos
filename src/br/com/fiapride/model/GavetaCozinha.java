package br.com.fiapride.model;

public class GavetaCozinha extends Gaveta implements Organizavel {

    private int quantidadeTalheres;

    public GavetaCozinha(String nome,
                         String identificador,
                         Armario armario,
                         int quantidadeTalheres) {

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
    public String tipoDeOrganizacao() {
        return "Organização de talheres e utensílios.";
    }

    @Override
    public void organizar() {
        System.out.println("A gaveta de cozinha organizou os talheres.");
    }

    @Override
    public String verificarStatus() {
        return "Gaveta de cozinha organizada.";
    }
}