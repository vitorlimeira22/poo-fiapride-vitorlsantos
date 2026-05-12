package br.com.fiapride.model;

public class Armario {

    private String nome;
    private String material;

    public Armario(String nome, String material) {
        this.setNome(nome);
        this.setMaterial(material);
    }

    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getMaterial() {
        return this.material;
    }

    private void setMaterial(String material) {
        this.material = material;
    }
}