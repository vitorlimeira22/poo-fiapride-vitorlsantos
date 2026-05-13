package br.com.fiapride.main;

import br.com.fiapride.model.Armario;
import br.com.fiapride.model.Gaveta;
import br.com.fiapride.model.GavetaCozinha;
import br.com.fiapride.model.GavetaEscritorio;

public class TesteGaveta {

    public static void main(String[] args) {

        Armario armario1 = new Armario("Armário Escritório", "Madeira");
        Armario armario2 = new Armario("Armário Cozinha", "Aço");

        // TESTE DA CLASSE ABSTRATA
        // Gaveta gaveta = new Gaveta("Teste", "G000", armario1);
        // O Java exibirá erro porque classes abstratas não podem ser instanciadas.

        GavetaEscritorio gavetaEscritorio =
                new GavetaEscritorio(
                        "Gaveta Office",
                        "GE001",
                        armario1,
                        15
                );

        GavetaCozinha gavetaCozinha =
                new GavetaCozinha(
                        "Gaveta Talheres",
                        "GC001",
                        armario2,
                        30
                );

        System.out.println("--- Teste Classe Abstrata ---");

        System.out.println(gavetaEscritorio.getNome()
                + " -> "
                + gavetaEscritorio.tipoDeOrganizacao());

        System.out.println(gavetaCozinha.getNome()
                + " -> "
                + gavetaCozinha.tipoDeOrganizacao());

    }
}