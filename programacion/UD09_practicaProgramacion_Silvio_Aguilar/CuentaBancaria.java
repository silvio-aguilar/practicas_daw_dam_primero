package org.example;

public class CuentaBancaria {

    private double saldo;

    // Constructor
    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    // Depositar
    public void depositar(double cantidad) throws CantidadInvalidaException {
        if (cantidad <= 0) {
            throw new CantidadInvalidaException("Cantidad a depositar inválida.");
        }
        saldo += cantidad;
    }

    // Retirar
    public void retirar(double cantidad)
            throws CantidadInvalidaException, FondosInsuficientesException {

        if (cantidad <= 0) {
            throw new CantidadInvalidaException("Cantidad a retirar inválida.");
        }

        if (cantidad > saldo) {
            throw new FondosInsuficientesException("Fondos insuficientes.");
        }

        saldo -= cantidad;
    }

    // Getter
    public double getSaldo() {
        return saldo;
    }
}
