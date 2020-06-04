package br.edu.newtonpaiva.poo.u6.vetores;


public class Main {

    public static void main(String[] args) {
        // Criar Escola
        Escola e = new Escola();

        // Criar Alunos
        Aluno a1 = new Aluno("123456", "José das Couves");
        Aluno a2 = new Aluno("654321", "Maria das Couves");

        // Adicionar alunos na escola
        e.adicionarAluno(a1);
        e.adicionarAluno(a2);

        // exibir a escola com os alunos
        e.imprimirAlunos();
    }

}
