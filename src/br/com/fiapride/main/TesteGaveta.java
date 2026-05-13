package br.com.fiapride.main;

import br.com.fiapride.model.Armario;
import br.com.fiapride.model.Caixa;
import br.com.fiapride.model.GavetaCozinha;
import br.com.fiapride.model.GavetaEscritorio;
import br.com.fiapride.model.Organizavel;

public class TesteGaveta {

    public static void main(String[] args) {

        Armario armario1 = new Armario("Armário Escritório", "Madeira");
        Armario armario2 = new Armario("Armário Cozinha", "Aço");

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

        Caixa caixa = new Caixa("Documentos");

        // POLIMORFISMO COM INTERFACE
        Organizavel[] organizaveis = {
                gavetaEscritorio,
                gavetaCozinha,
                caixa
        };

        System.out.println("--- Teste Interface Organizavel ---");

        for (Organizavel item : organizaveis) {

            item.organizar();

            System.out.println(item.verificarStatus());

            System.out.println("-------------------");
        }
    }
}