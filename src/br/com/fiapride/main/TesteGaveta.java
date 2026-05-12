package br.com.fiapride.main;

// Importamos a classe Gaveta para que o sistema a reconheça
import br.com.fiapride.model.Gaveta;

public class TesteGaveta {

    public static void main(String[] args) {

        // INSTANCIAÇÃO // O comando 'new' aloca memória para um novo objeto.
        // Criando a primeira gaveta (Objeto 1)
        Gaveta gaveta1 = new Gaveta("Gaveta Escritório", "G001");
        System.out.println(">>> Adicionando capacidade Gaveta 1:");
        gaveta1.adicionarCapacidade(50.0);

        Gaveta gaveta2 = new Gaveta("Gaveta Cozinha", "G002");
        System.out.println(">>> Adicionando capacidade Gaveta 2:");
        gaveta2.adicionarCapacidade(12.5);

        System.out.println("\n--- Status das Gavetas ---");
        // Lendo os dados com os Getters:
        System.out.println("Gaveta: " + gaveta1.getNome() + " | Capacidade: " + gaveta1.getCapacidade() + " | Identificador: " + gaveta1.getIdentificador());
        System.out.println("Gaveta: " + gaveta2.getNome() + " | Capacidade: " + gaveta2.getCapacidade() + " | Identificador: " + gaveta2.getIdentificador());

        System.out.println("\n--- Armazenando Itens ---");
        System.out.println("Armazenando item na gaveta 1...");
        gaveta1.armazenarItem(20.0); // Gaveta 1 tem 50, vai sobrar 30.

        System.out.println("\nArmazenando item na gaveta 2...");
        gaveta2.armazenarItem(20.0); // Gaveta 2 tem 12.5. O sistema DEVE bloquear!

        // Tente hackear o sistema descomentando a linha abaixo:
        // gaveta1.capacidade = 999999.0; // O Java vai exibir erro vermelho! A proteção funcionou!
    }
}