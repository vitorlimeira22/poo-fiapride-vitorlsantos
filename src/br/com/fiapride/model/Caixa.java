package br.com.fiapride.model;

public class Caixa implements Organizavel {

    private String etiqueta;

    public Caixa(String etiqueta) {
        this.setEtiqueta(etiqueta);
    }

    public String getEtiqueta() {
        return this.etiqueta;
    }

    private void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public void organizar() {
        System.out.println("A caixa organizou os objetos armazenados.");
    }

    @Override
    public String verificarStatus() {
        return "Caixa organizada.";
    }
}