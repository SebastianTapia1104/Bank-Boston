package bank.boston;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankBoston {
    
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenuPrincipal();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número para la opción.");
                scanner.nextLine();
                opcion = 0;
                continue;
            }
            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    verDatosCliente();
                    break;
                case 3:
                    Depositar();
                    break;
                case 4:
                    Girar();
                    break;
                case 5:
                    consultarSaldo();
                    break;
                case 6:
                    System.out.println("Saliendo de la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);
        scanner.close();
    }
    
    // MENÚ PRINCIPAL
    private static void mostrarMenuPrincipal() {
        System.out.println("\n--- Menú Principal Bank Boston ---");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Ver datos de cliente");
        System.out.println("3. Depositar");
        System.out.println("4. Girar");
        System.out.println("5. Consultar saldo");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }
    
    // FUNCIONES DEL MENÚ
    private static void registrarCliente() {
        System.out.println("--- Registro de Cliente ---");
        String nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, dvCaracter;
        int rutNumerico = 0;
        int telefonoNumerico = 0;
        do { // Nombre
            System.out.print("Ingrese nombre: ");
            nombre = scanner.nextLine();
            if (nombre.trim().isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            }
        } while (nombre.trim().isEmpty());
        do { // Apellido paterno
            System.out.print("Ingrese apellido paterno: ");
            apellidoPaterno = scanner.nextLine();
            if (apellidoPaterno.trim().isEmpty()) {
                System.out.println("El apellido paterno no puede estar vacío.");
            }
        } while (apellidoPaterno.trim().isEmpty());
        do { // Apellido materno
            System.out.print("Ingrese apellido materno: ");
            apellidoMaterno = scanner.nextLine();
            if (apellidoMaterno.trim().isEmpty()) {
                System.out.println("El apellido materno no puede estar vacío.");
            }
        } while (apellidoMaterno.trim().isEmpty());
        do { //Domicilio
            System.out.print("Ingrese domicilio: ");
            domicilio = scanner.nextLine();
            if (domicilio.trim().isEmpty()) {
                System.out.println("El domicilio no puede estar vacío.");
            }
        } while (domicilio.trim().isEmpty());
        do { // Comuna
            System.out.print("Ingrese comuna: ");
            comuna = scanner.nextLine();
            if (comuna.trim().isEmpty()) {
                System.out.println("La comuna no puede estar vacía.");
            }
        } while (comuna.trim().isEmpty());
        // Teléfono
        boolean telefonoValido = false;
        do {
            System.out.print("Ingrese teléfono (9 dígitos, ej: 912345678): ");
            try {
                telefonoNumerico = scanner.nextInt();
                scanner.nextLine();
                if (String.valueOf(telefonoNumerico).length() != 9) {
                    System.out.println("El teléfono debe tener exactamente 9 dígitos.");
                } else if (telefonoNumerico <= 0) {
                    System.out.println("El teléfono debe ser un número positivo.");
                }
                else {
                    telefonoValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números para el teléfono.");
                scanner.nextLine();
            }
        } while (!telefonoValido);
        // RUT
        boolean rutValido = false;
        do {
            System.out.print("Ingrese Rut (solo números, sin puntos ni guion): ");
            try {
                rutNumerico = scanner.nextInt();
                scanner.nextLine();
                if (rutNumerico <= 0) {
                    System.out.println("El Rut debe ser un número positivo.");
                } else if (String.valueOf(rutNumerico).length() < 7 || String.valueOf(rutNumerico).length() > 9) {
                    System.out.println("Longitud de Rut inválida. Debe ser entre 7 y 9 dígitos.");
                } else {
                    rutValido = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números para el Rut.");
                scanner.nextLine();
            }
        } while (!rutValido);
        // Digito verificador
        boolean dvValido = false;
        do {
            System.out.print("Ingrese Dígito Verificador (número 0-9 o 'K'): ");
            dvCaracter = scanner.nextLine().trim().toUpperCase();
            if (dvCaracter.isEmpty()) {
                System.out.println("El Dígito Verificador no puede estar vacío.");
            } else if (!dvCaracter.matches("[0-9K]")) {
                 System.out.println("Dígito Verificador inválido. Debe ser un número (0-9) o la letra 'K'.");
            } else {
                dvValido = true;
            }
        } while (!dvValido);

        int numeroCuenta = (int) (100000000 + Math.random() * 900000000);

        Cliente cliente = new Cliente(rutNumerico, dvCaracter, nombre, apellidoPaterno, apellidoMaterno, domicilio, comuna, telefonoNumerico, numeroCuenta);
        System.out.println("Cliente registrado exitosamente.");
        clientes.add(cliente);
    }

    private static void verDatosCliente() {
        System.out.println("\n--- Ver Datos de Cliente ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún. Por favor, registre un cliente primero.");
            return;
        }
        System.out.print("Ingrese el RUT del cliente (solo números, sin puntos ni guion): ");
        int rutBuscar;
        try {
            rutBuscar = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese solo números para el RUT.");
            scanner.nextLine();
            return;
        }
        Cliente clienteEncontrado = buscarClientePorRut(rutBuscar);
        if (clienteEncontrado != null) {
            clienteEncontrado.visualizarDatosPersonales();
            clienteEncontrado.getCuenta().visualizarDatosCuenta();
        } else {
            System.out.println("Cliente con RUT " + rutBuscar + " no encontrado.");
        }
    }
        
    private static void Depositar() {
        System.out.println("\n--- Realizar Depósito ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún. Por favor, registre un cliente primero.");
            return;
        }
        System.out.print("Ingrese el RUT del cliente para depositar: ");
        int rutBuscar;
        try {
            rutBuscar = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese solo números para el RUT.");
            scanner.nextLine();
            return;
        }
        Cliente clienteEncontrado = buscarClientePorRut(rutBuscar);
        if (clienteEncontrado != null) {
            System.out.print("Ingrese la cantidad a depositar: ");
            int monto;
            try {
                monto = scanner.nextInt();
                scanner.nextLine();
                clienteEncontrado.getCuenta().depositar(monto);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números para el monto.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Cliente con RUT " + rutBuscar + " no encontrado.");
        }
    }

    private static void Girar() {
        System.out.println("\n--- Realizar Giro ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún. Por favor, registre un cliente primero.");
            return;
        }
        System.out.print("Ingrese el RUT del cliente para girar: ");
        int rutBuscar;
        try {
            rutBuscar = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese solo números para el RUT.");
            scanner.nextLine();
            return;
        }
        Cliente clienteEncontrado = buscarClientePorRut(rutBuscar);
        if (clienteEncontrado != null) {
            System.out.print("Ingrese la cantidad a girar: ");
            int monto;
            try {
                monto = scanner.nextInt();
                scanner.nextLine();
                clienteEncontrado.getCuenta().girar(monto);
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese solo números para el monto.");
                scanner.nextLine();
            }
        } else {
            System.out.println("Cliente con RUT " + rutBuscar + " no encontrado.");
        }
    }

    private static void consultarSaldo() {
        System.out.println("\n--- Consultar Saldo ---");
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados aún. Por favor, registre un cliente primero.");
            return;
        }
        System.out.print("Ingrese el RUT del cliente para consultar saldo: ");
        int rutBuscar;
        try {
            rutBuscar = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, ingrese solo números para el RUT.");
            scanner.nextLine();
            return;
        }
        Cliente clienteEncontrado = buscarClientePorRut(rutBuscar);
        if (clienteEncontrado != null) {
            clienteEncontrado.getCuenta().consultarSaldo(); 
        } else {
            System.out.println("Cliente con RUT " + rutBuscar + " no encontrado.");
        }
    }
    
    //AUXILIARES
    private static Cliente buscarClientePorRut(int rut) {
        for (Cliente c : clientes) {
            if (c.getRut() == rut) {
                return c;
            }
        }
        return null;
    }
    
}