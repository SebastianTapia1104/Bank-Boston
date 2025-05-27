package bank.boston;

public class Cliente {
	
    private int rut;
    private String dv; // Digito verificador
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String domicilio;
    private String comuna;
    private int telefono;
    private Cuenta cuenta;
    
    public Cliente(int rut,String dv ,String nombre, String apellidoPaterno, String apellidoMaterno, String domicilio, String comuna, int telefono, int numeroCuenta) {
        this.dv = dv;
        this.rut = rut;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.domicilio = domicilio;
        this.comuna = comuna;
        this.telefono = telefono;
        this.cuenta = new Cuenta(numeroCuenta); // Se instancia la clase Cuenta
    }

    // GETTERS Y SETTERS
    
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }
    
    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
    
    //MÉTODOS
    public void visualizarDatosPersonales() {
        System.out.println("Rut: " + this.rut);
        System.out.println("Digito verificador: " + this.dv);
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido paterno: " + this.apellidoPaterno);
        System.out.println("Apellido materno: " + this.apellidoMaterno);
        System.out.println("Domicilio: " + this.domicilio);
        System.out.println("Comuna: " + this.comuna);
        System.out.println("Teléfono: " + this.telefono);
    }
    
}