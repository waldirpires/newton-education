package br.edu.newtonpaiva.poo.u6.arraylist;

import br.edu.newtonpaiva.poo.u6.vetores.Aluno;

public class Main {

    public static void main(String[] args) {

        // Criar Escola
        Escola e = new Escola();

        // Criar Alunos
        Aluno a1 = new Aluno("123456", "José das Couves");
        Aluno a2 = new Aluno("654321", "Maria das Couves");

        // Adicionar Alunos na escola
        e.adicionarAluno(a1);
        e.adicionarAluno(a2);

        // Exibir quantidade de alunos
        System.out.println("Alunos: " + e.getQuantidade());

        // Exibir os alunos
        e.imprimirAlunos();

    }

}
