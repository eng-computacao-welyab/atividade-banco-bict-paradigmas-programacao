package dev.welyab.bict.engcomp;

import java.math.BigDecimal;

public class Banco {

    public static void main(String[] args) {
        Conta conta = new Conta(bigdecimal("0.00"), bigdecimal("100.00"));

        System.out.println(conta);
        System.out.println("Sacando 90.00");
        conta.sacar(bigdecimal("90.00"));
        System.out.println(conta);
        System.out.println("Sacando 50.00");
        try {
            conta.sacar(bigdecimal("90.00"));
        } catch (ContaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Depositando 250.00");
        conta.depositar(bigdecimal("250.00"));
        System.out.println(conta);
        System.out.println("Sacando todo o saldo e o limite da conta");
        System.out.printf("Saldo = %s, limite = %s%n", conta.getSaldo(), conta.getLimite());
        conta.sacar(conta.getSaldo().add(conta.getLimite()));
        System.out.println(conta);

        System.out.println("Depositando um valor negativo: -500.00");
        try {
            conta.depositar(bigdecimal("-500.00"));
        } catch (ContaException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Depositando 150.00");
        conta.depositar(bigdecimal("150.00"));
        System.out.println(conta);

        System.out.println("Ajustando o limite para 600.00");
        conta.setLimite(bigdecimal("600.00"));
        System.out.println(conta);
    }

    private static BigDecimal bigdecimal(String valor) {
        return new BigDecimal(valor);
    }
}
