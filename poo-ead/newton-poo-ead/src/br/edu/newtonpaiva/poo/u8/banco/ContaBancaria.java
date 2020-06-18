package br.edu.newtonpaiva.poo.u8.banco;

class ContaBancaria {

    String agencia;

    String numero;

    Correntista correntista;

    private float saldo;

    public void depositar(float valor) throws DepositoInvalidoException {

        if (valor <= 0) {
            throw new DepositoInvalidoException("Valor de depósito inválido: " + valor);
        }

        saldo += valor;
        System.out.println("Deposito realizado com sucesso.");
    }

    public void sacar(float valor) {

        // se tentar sacar um valor superior ao saldo disponivel
        if (valor > saldo) {
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }

        saldo -= valor;
        System.out.println("Saque realizado com sucesso.");
    }

    public float getSaldo() {
        return saldo;
    }
}
