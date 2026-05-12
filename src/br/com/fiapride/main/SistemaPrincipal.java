package br.com.fiapride.main;

// Importamos a classe Passageiro para que o sistema a reconheça
import br.com.fiapride.model.Passageiro;
import br.com.fiapride.model.Gaveta;

public class SistemaPrincipal {

    public static void main(String[] args) {

        Gaveta gaveta1 = new Gaveta("Gaveta Escritório", "G001");
        System.out.println("Adicionando capacidade gaveta 1");
        gaveta1.adicionarCapacidade(50.0);

        // Criando a segunda gaveta (Objeto 2)
        Gaveta gaveta2 = new Gaveta("Gaveta Cozinha", "G002");
        System.out.println("Adicionando capacidade gaveta 2");
        gaveta2.adicionarCapacidade(12.5);

        System.out.println("--- Sistema Gavetas ---");
        System.out.println("Gaveta: " + gaveta1.nome + " | Capacidade: " + gaveta1.capacidade + " | Identificador: " + gaveta1.identificador);
        System.out.println("Gaveta: " + gaveta2.nome + " | Capacidade: " + gaveta2.capacidade + " | Identificador: " + gaveta2.identificador);

        System.out.println("Armazenando item na gaveta 1");
        gaveta1.armazenarItem(20);

        System.out.println("Armazenando item na gaveta 2");
        gaveta2.armazenarItem(20);




        // INSTANCIAÇÃO
        // O comando 'new' aloca memória para um novo objeto.
        // Criando o primeiro passageiro (Objeto 1)
        Passageiro passageiro1 = new Passageiro("Ana Silva", "222");
        System.out.println("Regarga passageiro 1");
        passageiro1.adicionarSaldo(50.0);

        // Criando o segundo passageiro (Objeto 2)
        Passageiro passageiro2 = new Passageiro("Carlos Souza", "333");
        System.out.println("Regarga passageiro 2");
        passageiro2.adicionarSaldo(12.5);

        System.out.println("--- Sistema FiapRide ---");
        System.out.println("Passageiro: " + passageiro1.nome + " | Saldo: R$ " + passageiro1.saldo + " | CPF: " + passageiro1.cpf);
        System.out.println("Passageiro: " + passageiro2.nome + " | Saldo: R$ " + passageiro2.saldo + " | CPF: " + passageiro2.cpf);

        System.out.println("Pagando viagem do passageiro 1");
        passageiro1.pagarViagem(20);
        System.out.println("Pagando viagem do passageiro 2");
        passageiro2.pagarViagem(20);

    }
}