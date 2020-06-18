package br.edu.newtonpaiva.poo.u8.banco;

import javax.swing.JOptionPane;

import br.edu.newtonpaiva.poo.u7.joptionpane.JOptionPaneUtil;

public class Main {

    public static void main(String[] args) {

        // criar uma nova conta corrente
        ContaBancaria cb = new ContaBancaria();
        cb.agencia = JOptionPaneUtil.exibirJanelaDeEntrada("Digite o número da agência:");
        cb.numero = JOptionPaneUtil.exibirJanelaDeEntrada("Digite o número da conta:");

        // criar o correntista
        String nome = JOptionPaneUtil.exibirJanelaDeEntrada("Digite o nome do correntista:");
        Correntista c = new Correntista(nome);
        cb.correntista = c;

        String opcao = null;

        String opcoes[] = { "Depósito", "Saque", "Saldo", "Sair" };

        String cabecalho = cb.agencia + "/" + cb.numero + " - " + nome;

        while (!"Sair".equals(opcao)) {

            opcao = JOptionPaneUtil
                    .exibirJanelaDeOpcoesLista("Banco POO: Operações",
                            cabecalho + "\n\nSelecione uma das operações abaixo:", opcoes)
                    .toString();

            String sValor = null;
            switch (opcao) {
            case "Depósito":

                sValor = JOptionPaneUtil.exibirJanelaDeEntrada("Digite o valor para ser depositado:");

                try {

                    cb.depositar(Float.parseFloat(sValor));

                    JOptionPaneUtil.exibirJanela(opcao,
                            opcao + " em conta de [" + cb.getSaldo() + "] realizado com sucesso.",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    JOptionPaneUtil.exibirJanelaDeErro(opcao,
                            "Não foi possível efetuar a operação de " + opcao + ": " + e.getMessage());
                }

                break;

            case "Saque":

                sValor = JOptionPaneUtil.exibirJanelaDeEntrada("Digite o valor para ser sacado:");

                try {

                    cb.sacar(Float.parseFloat(sValor));

                    JOptionPaneUtil.exibirJanela(opcao,
                            opcao + " em conta de [" + cb.getSaldo() + "] realizado com sucesso.",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    JOptionPaneUtil.exibirJanelaDeErro(opcao,
                            "Não foi possível efetuar a operação de " + opcao + ": " + e.getMessage());
                }

                break;
            case "Saldo":

                JOptionPaneUtil.exibirJanela("Saldo", "Saldo em conta: " + cb.getSaldo(),
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}
