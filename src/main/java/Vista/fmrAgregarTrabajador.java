package Vista;

import javax.swing.*;

import Clases.Trabajador;

import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fmrAgregarTrabajador extends JDialog {

    // ===== ATRIBUTOS =====
    private Trabajador nuevoTrabajador;
    private JPanel jpAgregar;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtIsapre;
    private JTextField txtAfp;
    private JTextField txtRut;
    private JButton btnSalir;
    private JButton btnLimpiar;
    private JButton btnAgregar;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblRut;
    private JLabel lblIsapre;
    private JLabel lblAfp;
    private JLabel lblAgregarTrabajador;
    private JTable tblListado;
    private JButton btnBuscar;
    private JButton btnListar;


    // ===== CONSTRUCTOR =====
    public fmrAgregarTrabajador(){
        setModal(true);
        setTitle("Agregar Trabajador");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setContentPane(jpAgregar);


        // ===== BOTÓN SALIR =====
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        // ===== BOTÓN AGREGAR =====
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trabajador nuevoTrabajador = grabar();
                setNuevoTrabajador(nuevoTrabajador);
                Controlador.csvTrabajador.agregarTrabajadorCsv(nuevoTrabajador);
                JOptionPane.showMessageDialog(null, " Trabajador agregado correctamente ");
                limpiar();
                cargarListadoTrabajadores(null);
            }
        });



        // ===== BOTÓN LIMPIAR =====
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });


        // ===== BUSCAR TRABAJADOR =====
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarTrabajadorPorRut();
            }
        });


        // ===== BOTÓN LISTAR =====
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
                cargarListadoTrabajadores(null);
            }
        });
    }

    // ========== SET NUEVO TRABAJADOR ==========
    public void setNuevoTrabajador(Trabajador nuevoTrabajador) {
        this.nuevoTrabajador = nuevoTrabajador;
    }



    // ===== GRABAR TRABAJADOR =====
    Trabajador grabar(){
        String rut      = txtRut.getText();
        String nombre   = txtNombre.getText();
        String apellido = txtApellido.getText();
        String isapre   = txtIsapre.getText();
        String afp      = txtAfp.getText();

        Trabajador nuevoTrabajador = new Trabajador(rut     ,nombre  , apellido,
                                                    isapre  , afp);

        return nuevoTrabajador;
    }



    // ========== LIMPIAR ==========
    public void limpiar() {
        txtRut      .setText(null);
        txtNombre   .setText(null);
        txtApellido .setText(null);
        txtIsapre   .setText(null);
        txtAfp      .setText(null);
    }



    // ========== CARGAR LISTADO TRABAJADORES ==========
    private void cargarListadoTrabajadores(String filtroRut) {
        List<Object[]> trabajadoresData = Controlador.csvTrabajador.listadoTrabajadores(filtroRut);

        DefaultTableModel modelo = new DefaultTableModel();

        // Ajusta el orden de las columnas aquí
        String[] columnas = {"Rut Trabajador", "Nombres Trabajador", "Apellidos Trabajador", "ISAPRE Trabajador", "AFP Trabajador"};
        modelo.setColumnIdentifiers(columnas);

        for (Object[] rowData : trabajadoresData) {
            modelo.addRow(rowData);
        }

        tblListado.setModel(modelo);

        // Establecer nombres a cada columna
        tblListado.getColumnModel().getColumn(0).setHeaderValue("Rut");
        tblListado.getColumnModel().getColumn(1).setHeaderValue("Nombres");
        tblListado.getColumnModel().getColumn(2).setHeaderValue("Apellidos");
        tblListado.getColumnModel().getColumn(3).setHeaderValue("ISAPRE");
        tblListado.getColumnModel().getColumn(4).setHeaderValue("AFP");
    }


    // ========== BUSCAR TRABAJADOR POR RUT ==========
    private void buscarTrabajadorPorRut() {
        String filtroRut = txtRut.getText();
        cargarListadoTrabajadores(filtroRut);
    }
}
