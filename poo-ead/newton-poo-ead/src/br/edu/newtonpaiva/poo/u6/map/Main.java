package br.edu.newtonpaiva.poo.u6.map;

import java.util.HashMap;
import java.util.Map;

import br.edu.newtonpaiva.poo.u6.stack.Livro;

public class Main {

    public static void main(String[] args) {
        Map<String, Livro> livros = new HashMap<>();

        // Criar livros
        Livro l1 = new Livro("123456", "Quem mexeu no meu queijo?", "Tom Hopkins");
        Livro l2 = new Livro("654321", "Amor a primeira vista", "Clara Johnson");
        Livro l3 = new Livro("123654", "O Mochileiro das Galáxias", "Arthur C. Clarke");

        livros.put(l1.getIsbn(), l1);
        livros.put(l2.getIsbn(), l2);
        livros.put(l3.getIsbn(), l3);

        for (String k : livros.keySet()) {
            System.out.println(k + ": " + livros.get(k));
        }
    }

}
