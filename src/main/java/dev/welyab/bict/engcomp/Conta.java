package dev.welyab.bict.engcomp;

import java.math.BigDecimal;

public class Conta {

    private BigDecimal saldo;
    private BigDecimal limite;

    public Conta() {
        saldo = BigDecimal.ZERO;
        limite = BigDecimal.ZERO;
    }

    public Conta(BigDecimal saldo, BigDecimal limite) {
        this.saldo = saldo;
        this.limite = limite;
    }

    public void sacar(BigDecimal valor) {
        if (valor.signum() < 0) {
            throw new ContaException(String.format("Não pode sacar valor negativo: %s", valor));
        }
        if (getSaldoComLimite().compareTo(valor) < 0) {
            throw new ContaException(String.format(
                    "Saldo e limite insuficientes: saldo = %s, limite = %s, valor do saque = %s",
                    saldo, limite, valor
            ));
        }
        saldo = saldo.subtract(valor);
    }

    public void depositar(BigDecimal valor) {
        if (valor.signum() < 0) {
            throw new ContaException(String.format("Não pode depositar valor negativo: %s", valor));
        }
        saldo = saldo.add(valor);
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal valor) {
        if (valor.signum() < 0) {
            throw new ContaException(String.format("Não ajustar um limite negativo: %s", valor));
        }
        this.limite = valor;
    }

    private BigDecimal getSaldoComLimite() {
        return saldo.add(limite);
    }

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                ", limite=" + limite +
                '}';
    }
}
