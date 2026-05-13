package br.com.fiapride.main;

import br.com.fiapride.model.Carro;
import br.com.fiapride.model.Moto;

public class SistemaPrincipal {
    public static void main(String[] args) {

        System.out.println("--- FIAPRIDE: Teste de Frota ---");

        // 1. Instanciando os objetos específicos
        Carro uberX = new Carro("ABC-1234", "Chevrolet Onix", 4);
        Moto mottu = new Moto("ABC-9999", "Caloi City", true);

        // 2. O TESTE: Um Carro consegue acessar getPlaca() da mãe?
        // Sim! Note que nós não escrevemos getPlaca() dentro da classe Carro. Ele herdou!
        System.out.println("Carro modelo: " + uberX.getModelo() + " | Placa: " + uberX.getPlaca());
        System.out.println("Vagas para passageiros: " + uberX.getCapacidadePassageiros());

        System.out.println("\nMoto modelo: " + mottu.getModelo() + " | Placa: " + mottu.getPlaca());

        // Se a moto é elétrica, ela avisa:
        if (mottu.isEletrica()) {
            System.out.println("Atenção: Esta moto é elétrica e atinge maiores velocidades!");
        }
    }
}