package bank.boston;

public class Cuenta {

    private int numeroCuenta;
    private int saldo;
    
    // Constructor    
    public Cuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
    }

    // GETTERS Y SETTERS
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    // MÉTODOS
	public boolean depositar(int monto) {
        if (monto <= 0) {
            return false;
        } else {
            this.saldo += monto;
            return true;
        }
    }

    public boolean girar(int monto) {
        if (monto <= 0) {
            System.out.println("No se permite el ingreso de montos menores o iguales a cero.");
            return false;
        }
        if (saldo >= monto) {
            saldo -= monto;
            System.out.println("Giro realizado con éxito.");
            return true;
        } else {
            System.out.println("Saldo insuficiente.");
            return false;
        }
        
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: " + this.saldo + " pesos"); // Current balance: [balance] pesos [cite: 27]
    }
	
    public void visualizarDatosCuenta() {
        System.out.println("--- Datos de la Cuenta ---");
        System.out.println("Número de Cuenta: " + this.numeroCuenta);
        System.out.println("Saldo Actual: " + this.saldo + " pesos");
    }
    
}