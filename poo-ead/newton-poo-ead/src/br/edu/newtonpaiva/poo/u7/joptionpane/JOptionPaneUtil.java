package br.edu.newtonpaiva.poo.u7.joptionpane;

import javax.swing.JOptionPane;

public class JOptionPaneUtil {

    public static int exibirJanelaDeConfirmacao(String titulo, String msg) {
        return JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION);
    }

    public static int exibirJanelaDeOpcoesBotao(String titulo, String msg, String[] options) {
        return JOptionPane.showOptionDialog(null, msg, titulo, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
    }

    public static String exibirJanelaDeEntrada(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    public static void exibirJanela(String titulo, String msg, int tipo) {
        JOptionPane.showMessageDialog(null, msg, titulo, tipo);
    }

    public static void exibirJanelaDeErro(String titulo, String msg) {
        JOptionPane.showMessageDialog(null, msg, titulo, JOptionPane.ERROR_MESSAGE);
    }

    public static Object exibirJanelaDeOpcoesLista(String titulo, String msg, Object[] possibleValues) {
        return JOptionPane.showInputDialog(null, msg, titulo, JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
    }
}
