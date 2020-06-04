// Definição
public class Conta {
  // constantes
  private static final float MAX_DEPOSITO = 1000;
  private static final float MAX_SAQUE = 500;
  // Atributos
  private String nome;
  private double saldo;
  private String agencia;
  private String numero;

  // Construtor da classe
  public Conta(String nome, double saldo, String agencia, String numero) {
    this.nome = nome;
    this.saldo = saldo;
    this.agencia = agencia;
    this.numero = numero;
  } 

  public boolean depositar(float valor){

    mostrarSaldo();

    boolean depositoPermitido = true;

    if (valor <=0) {
      System.out.println("Valor de depósito inválido: " + valor);
      depositoPermitido = false;
    }

    if (valor > MAX_DEPOSITO) {
      System.out.println("Valor de depósito acima do permitido: " + valor);
      depositoPermitido = false;
    }

    if (!depositoPermitido) {
      System.out.println("NÃO foi possível realizar a operação DEPÓSITO.");
    } else {
      this.saldo += valor;
      mostrarSaldo();
      System.out.println("DEPÓSITO realizado com sucesso.");
    }

    return depositoPermitido;
  }

  public boolean sacar(float valor) {    
    return efetuarSaque(valor, false);
  }

  private boolean efetuarSaque(float valor, boolean ehPagamentoDeConta) {

    mostrarSaldo();

    boolean saquePermitido = true;
    if (valor <= 0) {
      System.out.println("Valor de saque inválido: " + valor);
      saquePermitido = false;
    }

    if (valor > saldo) {
      System.out.println("Valor de saque é maior que saldo disponível em conta: " + valor);
      saquePermitido = false;
    }

    if (valor > MAX_SAQUE && !ehPagamentoDeConta) {
      System.out.println("Valor de saque é maior que o valor permitido: " + valor);
      saquePermitido = false;
    }

    if (!saquePermitido) {
      System.out.println("NÃO foi possível realizar a operação SAQUE.");
    } else {
      this.saldo -= valor;
      mostrarSaldo();
      System.out.println("SAQUE realizado com sucesso.");
    }

    return saquePermitido;
  }

  public void exibirSaldo() {
    System.out.println("==========================");
    System.out.println("Agência: " + agencia);
    System.out.println("Número: " + numero);
    System.out.println("Nome: " + nome);

    mostrarSaldo();
  }

  private void mostrarSaldo() {
    System.out.println("==========================");

    System.out.println(String.format("Saldo: R$%.2f", saldo));
    System.out.println("==========================");
  }

  public boolean pagarConta(float valor, String destino, String dataVencimento, String dataPagamento) {
    // realizar saque do valor para pagamento de conta
    boolean saqueComSucesso = efetuarSaque(valor, true);

    if (!saqueComSucesso) {
      System.out.println("NÃO foi possível realizar a operação PAGAMENTO DE CONTAS.");
      return saqueComSucesso;
    }

    System.out.println("==========================");
    System.out.println("Origem:\t" + agencia + "." + numero);
    System.out.println("Destino:\t" + destino);
    System.out.println("Vencimento:\t" + dataVencimento);
    System.out.println("Pagamento:\t" + dataPagamento);
    System.out.println("==========================");

    System.out.println("PAGAMENTO DE CONTAS realizado com sucesso.");
    System.out.println("==========================");

    mostrarSaldo();

    return saqueComSucesso;
  }
}