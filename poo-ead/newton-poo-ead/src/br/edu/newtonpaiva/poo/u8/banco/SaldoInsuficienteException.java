package br.edu.newtonpaiva.poo.u8.banco;

public class SaldoInsuficienteException extends RuntimeException {

    public SaldoInsuficienteException(String msg) {
        super(msg);
    }
}
