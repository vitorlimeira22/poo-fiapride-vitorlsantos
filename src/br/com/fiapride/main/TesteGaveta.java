package br.com.fiapride.main;

// Importamos a classe Gaveta para que o sistema a reconheça
import br.com.fiapride.model.Armario;
import br.com.fiapride.model.Gaveta;

public class TesteGaveta {

    public static void main(String[] args) {

        Armario armario1 = new Armario("Armário Escritório", "Madeira");

        Gaveta gaveta1 = new Gaveta("Gaveta Escritório", "G001", armario1);

        System.out.println("--- Dados da Gaveta ---");

        System.out.println("Nome da gaveta: " + gaveta1.getNome());
        System.out.println("Identificador: " + gaveta1.getIdentificador());

        // TESTE DA ASSOCIAÇÃO
        System.out.println("Armário associado: " + gaveta1.getArmario().getNome());
        System.out.println("Material do armário: " + gaveta1.getArmario().getMaterial());

    }
}