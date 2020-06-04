package br.edu.newtonpaiva.poo.u6.vetores;

public class Escola {

    private static final int MAX_ALUNOS = 25;

    private Aluno[] alunos = new Aluno[MAX_ALUNOS];

    private int quantidade = 0;

    public void adicionarAluno(Aluno a) {

        if (quantidade == MAX_ALUNOS) {
            System.out.println("ERRO: Escola está cheia.");
            return;
        }

        setarAluno(quantidade, a);

        quantidade++;
    }

    public void setarAluno(int pos, Aluno a) {
        alunos[pos] = a;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void imprimirAlunos() {
        // exibir a escola com os alunos
        int pos = 0;
        for (Aluno a : alunos) {
            if (a != null) {
                System.out.println(pos + ": " + a);
            } else {
                System.out.println(pos + ": [ ]");
            }
            pos++;
        }
    }

}
