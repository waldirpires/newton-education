package br.edu.newtonpaiva.poo.u6.queue;

public class Main {

    public static void main(String[] args) {
        // criar banco
        Banco b = new Banco();

        // criar clientes
        Cliente c1 = new Cliente("José");
        Cliente c2 = new Cliente("Marcia");
        Cliente c3 = new Cliente("João");

        // enfileirar clientes
        b.entrarNaFila(c1);
        b.imprimirFila();

        b.entrarNaFila(c2);
        b.imprimirFila();

        b.entrarNaFila(c3);
        b.imprimirFila();

        System.out.println("Frente: " + b.obterFrente());

        // exibir fila

        // desenfileirar;
        Cliente c4 = b.sairDaFila();
        System.out.println("Saiu da fila: " + c4);
        b.imprimirFila();
    }
}
