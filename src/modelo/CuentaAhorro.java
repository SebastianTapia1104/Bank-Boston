package modelo;

import modelo.Cuenta;


// Herencia
public class CuentaAhorro extends Cuenta {

    private double tasaInteres;

    public CuentaAhorro(int numeroCuenta, double tasaInteres) {
        super(numeroCuenta);
        this.tasaInteres = tasaInteres;
    }

    public CuentaAhorro(int numeroCuenta, int saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public void aplicarIntereses() {
        this.saldo += (int)(this.saldo * tasaInteres);
        System.out.println("Intereses aplicados. Nuevo saldo: $" + this.saldo + " CLP");
    }
    
    
    // Sobrecarga
    // Podemos consultar el saldo tras hacer una proyeccion en años
    public double consultarSaldo(int años) {
        double saldoProyectado = this.saldo * Math.pow((1 + tasaInteres), años);
        return saldoProyectado;
    }

    @Override
    public void visualizarDatosCuenta() {
        System.out.println("--- Datos de la Cuenta de Ahorro ---");
        System.out.println("Número de Cuenta: " + this.getNumeroCuenta());
        System.out.println("Saldo Actual: $" + String.format("%.2f", this.getSaldo()) + " CLP");
        System.out.println("Tasa de Interés Anual: " + String.format("%.2f", (this.tasaInteres * 100)) + "%");
        System.out.println("\n--- Proyección de Saldo (interés compuesto) ---");
        double saldoProyectado3Años = consultarSaldo(3);
        System.out.println("Saldo en 3 años: $" + String.format("%.2f", saldoProyectado3Años) + " CLP");
        double saldoProyectado5Años = consultarSaldo(5);
        System.out.println("Saldo en 5 años: $" + String.format("%.2f", saldoProyectado5Años) + " CLP");
    }
}