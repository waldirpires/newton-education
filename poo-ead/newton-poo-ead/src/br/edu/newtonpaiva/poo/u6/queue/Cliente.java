package br.edu.newtonpaiva.poo.u6.queue;

public class Cliente implements Comparable<Cliente> {

    private String nome;

    public Cliente(String nome) {
        super();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Cliente o) {

        return this.nome.compareTo(o.getNome());
    }

}
