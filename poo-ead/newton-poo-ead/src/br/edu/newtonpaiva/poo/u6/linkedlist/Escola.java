package br.edu.newtonpaiva.poo.u6.linkedlist;

import java.util.LinkedList;
import java.util.List;

import br.edu.newtonpaiva.poo.u6.vetores.Aluno;

public class Escola {

    private List<Aluno> alunos = new LinkedList<>();

    public void adicionarAluno(Aluno a) {
        alunos.add(a);
    }

    public void adicionarAluno(int pos, Aluno a) {
        alunos.add(pos, a);
    }

    public int getQuantidade() {
        return alunos.size();
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

}
