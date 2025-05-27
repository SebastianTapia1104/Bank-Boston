/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bank.boston;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private ArrayList<Cliente> clientes;
    private List<Cuenta> cuentas;
    
    public Banco() {
        clientes = new ArrayList<>();
        cuentas = new ArrayList<>();
    }
    
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    
    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }
    
    public void agregarCuenta(Cuenta c) {
        cuentas.add(c);
    }
    /**
    *
    * public Cliente buscarClientePorRut(int rut) {
        for (Cliente c : clientes) {
            if (c.getRut() == rut) { 
                return c;
            }
        }
        return null;
    }
    */
    public Cuenta buscarCuentaPorNumero(int numero) {
        for (Cuenta c : cuentas) {
            if (c.getNumeroCuenta() == numero) { 
                return c;
            }
        }
        return null;
    }
    
    
    
}
