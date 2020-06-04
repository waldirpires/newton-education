package br.edu.newtonpaiva.poo.u6;

import br.edu.newtonpaiva.poo.u6.vetores.Aluno;

public interface EscolaInterface {

    void adicionarAluno(Aluno a);

    int getQuantidade();

    Aluno[] getAlunos();

}