package modelo;

import modelo.Cuenta;

// Herencia
public class CuentaCredito extends Cuenta {

    private double limiteCredito;
    private double saldoUtilizado;

    public CuentaCredito(int numeroCuenta, double limiteCredito) {
        super(numeroCuenta);
        this.limiteCredito = limiteCredito;
        this.saldoUtilizado = 0.0;
        this.saldo = limiteCredito;
        System.out.println("Cuenta de Crédito #" + numeroCuenta + " creada con un límite total de $" + String.format("%.2f", this.limiteCredito) + " CLP.");
    }

    public CuentaCredito(int numeroCuenta, double limiteCredito, double montoInicialUtilizado) {
        super(numeroCuenta, (int) (limiteCredito - montoInicialUtilizado));
        this.limiteCredito = limiteCredito;
        this.saldoUtilizado = montoInicialUtilizado; // Esto es lo que se ha utilizado
        if (this.saldoUtilizado > this.limiteCredito) {
            System.out.println("Advertencia: El monto inicial utilizado excede el límite de crédito.");
        }
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
        if (this.saldoUtilizado > limiteCredito) {
            System.out.println("Advertencia: El saldo utilizado excede el nuevo límite de crédito.");
        } else {
            this.saldo = limiteCredito - this.saldoUtilizado;
        }
    }

    public double getSaldoUtilizado() {
        return saldoUtilizado;
    }

    public void setSaldoUtilizado(double saldoUtilizado) {
        this.saldoUtilizado = saldoUtilizado;
        this.saldo = limiteCredito - saldoUtilizado;
    }

    @Override
    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto de pago debe ser mayor que cero.");
            return;
        }
        if (this.saldoUtilizado == 0) {
            System.out.println("No hay saldo utilizado para pagar en esta Cuenta de Crédito.");
            return;
        }
        double montoAPagar = Math.min(monto, this.saldoUtilizado);
        this.saldoUtilizado -= montoAPagar;
        this.saldo += montoAPagar; 
        System.out.println("Pago de $" + String.format("%.2f", montoAPagar) + " CLP realizado con éxito en Cuenta de Crédito.");
        System.out.println("Saldo utilizado actual: $" + String.format("%.2f", this.saldoUtilizado) + " CLP.");
        System.out.println("Crédito disponible: $" + String.format("%.2f", this.saldo) + " CLP.");
        if (this.saldoUtilizado <= 0.001) { 
            this.saldoUtilizado = 0.0;
            System.out.println("¡Deuda de tarjeta de crédito saldada completamente!");
            if (monto > montoAPagar) {
                System.out.println("Se realizó un sobrepago de $" + String.format("%.2f", (monto - montoAPagar)) + " CLP.");
            }
        }
    }
    
    @Override
    public void girar(double monto) {
        if (monto <= 0) {
            System.out.println("Error: El monto a gastar debe ser mayor que cero.");
            return;
        }
        if (this.saldo < monto) {
            System.out.println("Límite de crédito disponible insuficiente para realizar este gasto.");
            System.out.println("Crédito disponible: $" + String.format("%.2f", this.saldo) + " CLP. Monto solicitado: $" + String.format("%.2f", monto) + " CLP.");
            return;
        }
        this.saldo -= monto;
        this.saldoUtilizado += monto; 
        System.out.println("Gasto de $" + String.format("%.2f", monto) + " CLP realizado con éxito en Cuenta de Crédito.");
        System.out.println("Crédito disponible: $" + String.format("%.2f", this.saldo) + " CLP.");
        System.out.println("Saldo utilizado: $" + String.format("%.2f", this.saldoUtilizado) + " CLP.");
    }
    
    @Override
    public void consultarSaldo() {
        System.out.println("Crédito disponible en Cuenta de Crédito #" + this.numeroCuenta + ": $" + String.format("%.2f", this.getSaldo()) + " CLP.");
    }
    
    @Override
    public void visualizarDatosCuenta() {
        System.out.println("--- Datos de la Cuenta de Crédito ---");
        System.out.println("Número de Cuenta: " + this.getNumeroCuenta());
        System.out.println("Límite de Crédito Total: $" + String.format("%.2f", this.limiteCredito) + " CLP");
        System.out.println("Crédito Disponible: $" + String.format("%.2f", this.getSaldo()) + " CLP"); // El saldo aquí es el crédito disponible
        System.out.println("Saldo Utilizado: $" + String.format("%.2f", this.saldoUtilizado) + " CLP");
    }
    
}