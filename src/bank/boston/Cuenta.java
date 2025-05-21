package bank.boston;

public class Cuenta {

	private int numeroCuenta;
    private int saldo;
    
    // Constructor    
	public Cuenta(int numeroCuenta, int saldo) {
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

    // METODOS
	
	public void depositar(int monto) {
        if (monto <= 0) {
            System.out.println("No se permite el ingreso de montos menores o iguales a cero.");
        } else {
            this.saldo += monto;
            System.out.println("¡Depósito realizado de manera exitosa!");
            System.out.println("Usted tiene un saldo actual de " + this.saldo + " pesos.");
        }
    }

    public void girar(int monto) {
        if (this.saldo <= 0) {
            System.out.println("Para realizar un giro, cada cliente debe tener un saldo mayor que cero.");
        } else if (monto <= 0) {
            System.out.println("No se permite el ingreso de montos menores o iguales a cero.");
        } else if (monto > this.saldo) {
            System.out.println("No se permite realizar giros que excedan o superen el saldo de la cuenta.");
        } else {
            this.saldo -= monto;
            System.out.println("Giro realizado con éxito. Saldo actual: " + this.saldo + " pesos.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: " + this.saldo + " pesos"); // Current balance: [balance] pesos [cite: 27]
    }
	
}