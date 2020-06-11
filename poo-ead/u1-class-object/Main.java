class Main {
  
  public static void main(String[] args) {
    // Criar a conta
    Conta c = new Conta("José das Couves", 100.0, "3442-2", "12345-6");
    // Exibir o saldo
    c.exibirSaldo();
    // Depositar
    c.depositar(50);
    c.exibirSaldo();
    // Sacar
    c.sacar(30);
    c.exibirSaldo();

    // ex1: depósito
    c.depositar(2000);

    // ex2: saque
    c.sacar(100);

    // ex3: pagamento de contas
    c.pagarConta(20, "Cartão de Crédito", "2020.05.21", "2020.05.21");

    c.exibirSaldo();
  }
}