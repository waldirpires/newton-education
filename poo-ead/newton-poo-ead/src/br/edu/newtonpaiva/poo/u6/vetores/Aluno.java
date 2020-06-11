package br.edu.newtonpaiva.poo.u6.vetores;

public class Aluno {

    private String matricula;

    private String nome;

    public Aluno(String matricula, String nome) {
        super();
        this.matricula = matricula;
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return String.format("Matrícula: %s\t Nome: %s", this.matricula, this.nome);
    }

}
