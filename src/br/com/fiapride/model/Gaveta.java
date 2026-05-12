package br.com.fiapride.model;

public class Gaveta {
    private String nome;
    private String identificador;
    private double capacidade;

    public Gaveta(String nome, String identificador) {
        this.setNome(nome);
        this.setIdentificador(identificador);
        this.setCapacidade(0); // Toda gaveta começa com zero!
    }

    // Método para PEGAR a capacidade (Leitura)
    public double getCapacidade() {
        return this.capacidade; // Apenas devolve o valor, não altera nada.
    }

    // Método para DEFINIR a capacidade (Escrita com Regra de Negócio!)
    private void setCapacidade(double valor) {
        if (valor >= 0) {
            this.capacidade = valor;
        } else {
            System.out.println("Erro de Segurança: Tentativa de definir capacidade negativa bloqueada!");
        }
    }

    // Faça o mesmo para o nome (sem regras complexas por enquanto)
    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    // Faça o mesmo para o identificador (sem regras complexas por enquanto)
    public String getIdentificador() {
        return this.identificador;
    }

    private void setIdentificador(String identificador) {
        this.identificador = identificador;
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