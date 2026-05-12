package br.com.fiapride.model;

public class Gaveta {
    public String nome;
    public String identificador;
    public double capacidade;

    public Gaveta(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
        this.capacidade = 0.00;
    }

    public void adicionarCapacidade(double valor) {
        // Regra de negócio: O valor da capacidade deve ser positivo
        if (valor <= 0) {
            System.out.println("Erro: O valor da capacidade deve ser maior que zero.");
            return;
        }
        this.capacidade += valor;
        System.out.println("Capacidade adicionada. Nova capacidade: " + this.capacidade);
    }

    public void armazenarItem(double espaco) {
        // Regra de negócio: O espaço deve ser positivo e a capacidade deve ser suficiente
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
}