package org.BancoBlueMoon;

import javax.swing.*;

public class ContaBancaria {
    private double saldo;
    private double faturaCartaoCredito; // Novo atributo

    public ContaBancaria() {
        this.saldo = 0.0;
        this.faturaCartaoCredito = 0.0; // Inicializa a fatura do cartão
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            JOptionPane.showMessageDialog(null, "Deposito no valor de " + valor + " realizadoc com sucesso.");

        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            new JOptionPane("Saque de R$ " + valor + " realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
            return false;
        }
    }

    public void adicionarFatura(double valor) {
        faturaCartaoCredito += valor;
    }

    public double getFaturaCartaoCredito() {
        return faturaCartaoCredito;
    }
}
