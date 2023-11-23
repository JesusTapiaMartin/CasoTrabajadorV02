package Controlador;

import Clases.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class csvTrabajador {

    // ===== ATRIBUTOS =====
    public static final String nombreArchivo = "Trabajadores.csv";


    // ===== AGREGAR TRABAJADOR CSV =====
    public static void agregarTrabajadorCsv(Trabajador nuevoTrabajador) {
        try {
            File archivo = new File(nombreArchivo);

            // ----- SI EL ARCHIVO NO EXISTE-----
            if (!archivo.exists()) {
                BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));

                // ----- Encabezados -----
                escritor.write("RUT, NOMBRE, APELLIDO, ISAPRE, AFP");
                escritor.newLine();
                escritor.close();
            }


            // ===== ATRIBUTOS TRABAJADOR =====
            String rutTrabajador        = nuevoTrabajador.getRut();
            String nombreTrabajador     = nuevoTrabajador.getNombre();
            String apellidoTrabajador   = nuevoTrabajador.getApellido();
            String isapreTrabajador     = nuevoTrabajador.getIsapre();
            String afpTrabajador        = nuevoTrabajador.getAfp();


            // Agregar datos al final del archivo en modo append
            BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo, true));
            escritor.write( rutTrabajador       + "," + nombreTrabajador + "," + apellidoTrabajador + "," +
                            isapreTrabajador    + "," + afpTrabajador);


            // ----- NUEVA LÍNEA DESPUÉS PARA AGREGAR UN ALUMNO -----
            escritor.newLine();
            escritor.close();

        } catch (IOException e) {
            System.out.println("Error al registrar: " + e.getMessage());
        }
    }



    // ===== MOSTRAR TRABAJADORES CSV =====
    public static List<Object[]> listadoTrabajadores(String filtroRut) {
        List<Object[]> trabajadoresData = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] campos = linea.split(",");

                if (campos.length >= 5) {
                    String rutTrabajador        = campos[0].trim();
                    String nombreTrabajador     = campos[1].trim();
                    String apellidoTrabajador   = campos[2].trim();
                    String isapreTrabajador     = campos[3].trim();
                    String afpTrabajador        = campos[4].trim();

                    if (filtroRut == null || rutTrabajador.equals(filtroRut)) {
                        // Ajusta el orden de los datos aquí
                        Object[] rowData = {nombreTrabajador  , apellidoTrabajador    , rutTrabajador,
                                isapreTrabajador    , afpTrabajador};
                        trabajadoresData.add(rowData);
                    }
                }
            }
            lector.close();
        } catch (IOException e) {
            System.err.println("Hubo un error al leer el archivo: " + e.getMessage());
        }
        return trabajadoresData;
    }

}
