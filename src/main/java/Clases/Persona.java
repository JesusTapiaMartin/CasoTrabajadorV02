package Clases;

public class Persona {

    // ===== ATRIBUTOS =====
    private String rut, nombre, apellido;


    // ===== CONSTRUCTOR =====
    public Persona(String rut   , String nombre, String apellido) {
        this.nombre     = nombre;
        this.apellido   = apellido;
        this.rut        = rut;
    }


    // ===== GETTER =====
    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

}
