package br.com.fiapride.model;

// Adicionamos 'abstract' - agora esta classe NÃO pode ser instanciada!
public abstract class Veiculo {

    // ... atributos existentes ...
    private String placa;
    private String modelo;

    // CONSTRUTOR AINDA EXISTE!
    // Classes abstratas TEM construtor, mas só são chamados pelas filhas via super()
    public Veiculo(String placa, String modelo) {
        this.setPlaca(placa);
        this.modelo = modelo;
    }

    // MÉTODO CONCRETO (com corpo)
    // Mesmo sendo classe abstrata, pode ter métodos normais
    public String getModelo() {
        return this.modelo;
    }

    public String getPlaca() {
        return this.placa;
    }

    // MÉTODO ABSTRATO (sem corpo)
    // OBRIGA todas as filhas a implementarem este método!
    public abstract void exibirTipo();

    // Setters privados...
    private void setPlaca(String placa) {
        if (placa != null && placa.length() == 7) {
            this.placa = placa;
        }
    }
}