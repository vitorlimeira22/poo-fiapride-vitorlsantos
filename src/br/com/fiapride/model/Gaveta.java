package br.com.fiapride.model;

public class Gaveta {

    private String nome;
    private String identificador;
    private double capacidade;
    private Armario armario;

    public Gaveta(String nome, String identificador, Armario armario) {
        this.setNome(nome);
        this.setIdentificador(identificador);
        this.setCapacidade(0);
        this.setArmario(armario);
    }

    public double getCapacidade() {
        return this.capacidade;
    }

    private void setCapacidade(double valor) {
        if (valor >= 0) {
            this.capacidade = valor;
        } else {
            System.out.println("Erro de Segurança: Tentativa de definir capacidade negativa bloqueada!");
        }
    }

    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    private void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Armario getArmario() {
        return this.armario;
    }

    private void setArmario(Armario armario) {
        this.armario = armario;
    }

    public void adicionarCapacidade(double valor) {

        if (valor <= 0) {
            System.out.println("Erro: O valor da capacidade deve ser maior que zero.");
            return;
        }

        this.capacidade += valor;
        System.out.println("Capacidade adicionada. Nova capacidade: " + this.capacidade);
    }

    public void armazenarItem(double espaco) {

        if (espaco <= 0) {
            System.out.println("Erro: O espaço do item é inválido.");
            return;
        }

        if (this.capacidade < espaco) {
            System.out.println("Erro: Capacidade insuficiente para armazenar o item.");
            return;
        }

        this.capacidade -= espaco;
        System.out.println("Item armazenado. Capacidade restante: " + this.capacidade);
    }

    // MÉTODO GENÉRICO PARA POLIMORFISMO
    public String organizarItens() {
        return "A gaveta está organizando itens de forma genérica.";
    }
}