package br.edu.newtonpaiva.poo.u6.stack;

import java.util.Iterator;
import java.util.Stack;

public class MesaDaBiblioteca {

    private Stack<Livro> livros = new Stack<>();

    public void empilhar(Livro livro) {
        livros.push(livro);
    }

    public Livro desempilhar() {
        return livros.pop();
    }

    public Livro pegarTopo() {
        return livros.peek();
    }

    public int getQuantidade() {
        return livros.size();
    }

    public void imprimirPilha() {
        System.out.println("================================================\n");
        Iterator value = livros.iterator();

        while (value.hasNext()) {
            System.out.println(value.next());
        }
        System.out.println("================================================\n");

    }
}
