package br.com.fiapride.main;

import br.com.fiapride.model.Armario;
import br.com.fiapride.model.Gaveta;
import br.com.fiapride.model.GavetaCozinha;
import br.com.fiapride.model.GavetaEscritorio;

import java.util.ArrayList;
import java.util.List;

public class TesteGaveta {

    public static void main(String[] args) {

        Armario armario1 = new Armario("Armário Escritório", "Madeira");
        Armario armario2 = new Armario("Armário Cozinha", "Aço");

        GavetaEscritorio gavetaEscritorio =
                new GavetaEscritorio("Gaveta Office",
                        "GE001",
                        armario1,
                        15);

        GavetaCozinha gavetaCozinha =
                new GavetaCozinha("Gaveta Talheres",
                        "GC001",
                        armario2,
                        30);

        // POLIMORFISMO
        List<Gaveta> gavetas = new ArrayList<>();

        gavetas.add(gavetaEscritorio);
        gavetas.add(gavetaCozinha);

        System.out.println("--- Teste de Polimorfismo ---");

        for (Gaveta gaveta : gavetas) {
            System.out.println(gaveta.organizarItens());
        }
    }
}