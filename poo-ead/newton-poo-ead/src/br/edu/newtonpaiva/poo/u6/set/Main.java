package br.edu.newtonpaiva.poo.u6.set;

import java.util.HashSet;
import java.util.Set;

import br.edu.newtonpaiva.poo.u6.stack.Livro;

public class Main {

    public static void main(String[] args) {
        Set<Livro> livros = new HashSet<>();

        livros.add(new Livro("1", "a", "b"));
        livros.add(new Livro("2", "b", "c"));

        for (Livro l : livros) {
            System.out.println(l);
        }
    }
}
