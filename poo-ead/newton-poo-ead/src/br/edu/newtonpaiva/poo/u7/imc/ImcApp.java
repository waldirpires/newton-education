package br.edu.newtonpaiva.poo.u7.imc;

import javax.swing.JOptionPane;

public class ImcApp {

    public static void main(String[] args) {

        float peso; // Kg
        float altura; // m
        float imc;

        // ler o peso do usuário
        String inputValue = JOptionPane.showInputDialog("Digite o seu peso (Kg)");
        peso = Float.parseFloat(inputValue);
        JOptionPane.showMessageDialog(null, "Você digitou o peso: " + peso + " Kg", "Info",
                JOptionPane.INFORMATION_MESSAGE);

        // ler a altura do usuário
        inputValue = JOptionPane.showInputDialog("Digite a sua altura (metros)");
        altura = Float.parseFloat(inputValue);
        JOptionPane.showMessageDialog(null, "Você digitou a altura: " + altura + " metros", "Info",
                JOptionPane.INFORMATION_MESSAGE);
        // calcular o IMC
        imc = peso / (altura * altura);
        // Exibir o resultado

        String classificacao = null;
        // < 18.5 magreza
        // 18.5 e 24.9 normal
        // 25 e 29,9 sobrepeso
        // 30 39,9 obesidade
        // 40 obesidade grave.
        if (imc < 18.5) {
            classificacao = "MAGREZA";
        } else if (imc > 18.5 && imc < 24.9) {
            classificacao = "NORMAL";
        } else if (imc > 25 && imc < 29.9) {
            classificacao = "SOBREPESO";
        } else if (imc > 30 && imc < 39.9) {
            classificacao = "OBESIDADE";
        } else {
            classificacao = "OBESIDADE GRAVE";
        }

        String classificações = "\n\n< 18.5 MAGREZA\n18.5 e 24.9 NORMAL\n25 e 29.9 SOBREPESO\n"
                + "30 e 39.9 OBESIDADE\n>=40 OBESIDADE GRAVE";

        String msg = String.format("Seu IMC for de %.2f\nClassificação: %s" + classificações, imc, classificacao);

        JOptionPane.showMessageDialog(null, msg, "Resultado", JOptionPane.INFORMATION_MESSAGE);

    }
}
