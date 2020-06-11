package br.edu.newtonpaiva.poo.u6.stack;

public class Main {

    public static void main(String[] args) {
        // Criar a mesa
        MesaDaBiblioteca m = new MesaDaBiblioteca();

        // Criar livros
        Livro l1 = new Livro("123456", "Quem mexeu no meu queijo?", "Tom Hopkins");
        Livro l2 = new Livro("654321", "Amor a primeira vista", "Clara Johnson");
        Livro l3 = new Livro("123654", "O Mochileiro das Galáxias", "Arthur C. Clarke");

        // empilhar livros
        m.empilhar(l1);
        m.imprimirPilha();

        m.empilhar(l2);
        m.imprimirPilha();

        m.empilhar(l3);
        m.imprimirPilha();

        System.out.println("Topo: " + m.pegarTopo());

        // exibir a pilha

        // desempilhar livros
        Livro desempilhou = m.desempilhar();
        System.out.println("Desempilhou: " + desempilhou);
        m.imprimirPilha();

        // exibir a pilha
    }
}
