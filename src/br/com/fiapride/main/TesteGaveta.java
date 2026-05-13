package br.com.fiapride.main;

import br.com.fiapride.model.Armario;
import br.com.fiapride.model.GavetaCozinha;
import br.com.fiapride.model.GavetaEscritorio;

public class TesteGaveta {

    public static void main(String[] args) {

        Armario armario1 = new Armario("Armário Escritório", "Madeira");
        Armario armario2 = new Armario("Armário Cozinha", "Aço");

        GavetaEscritorio gavetaEscritorio =
                new GavetaEscritorio("Gaveta Office", "GE001", armario1, 15);

        GavetaCozinha gavetaCozinha =
                new GavetaCozinha("Gaveta Talheres", "GC001", armario2, 30);

        System.out.println("--- Gaveta Escritório ---");
        System.out.println("Nome: " + gavetaEscritorio.getNome());
        System.out.println("Armário: " + gavetaEscritorio.getArmario().getNome());
        System.out.println("Quantidade de canetas: " + gavetaEscritorio.getQuantidadeCanetas());

        System.out.println("\n--- Gaveta Cozinha ---");
        System.out.println("Nome: " + gavetaCozinha.getNome());
        System.out.println("Armário: " + gavetaCozinha.getArmario().getNome());
        System.out.println("Quantidade de talheres: " + gavetaCozinha.getQuantidadeTalheres());

    }
}