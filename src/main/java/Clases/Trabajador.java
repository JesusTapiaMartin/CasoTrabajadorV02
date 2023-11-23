package Clases;

import Clases.Persona;

public class Trabajador extends Persona {

    // ===== ATRIBUTOS =====
    private String isapre, afp;


    // ===== CONSTRUCTOR =====
    public Trabajador(  String rut      , String nombre, String apellido,
                        String isapre   , String afp) {
        super(rut, nombre, apellido);
        this.isapre = isapre;
        this.afp    = afp;
    }


    // ===== GETTER =====
    public String getIsapre() {
        return isapre;
    }

    public String getAfp() {
        return afp;
    }
}
