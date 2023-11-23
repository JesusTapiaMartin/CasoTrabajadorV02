package Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class fmrMenu extends JFrame{
    private JPanel jpMenu;
    private JButton btnAgregar;
    private JButton btnSalir;


    public fmrMenu(){
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setTitle("Menú");
        setContentPane(jpMenu);

        // ===== CAMBIO DE VENTANA =====
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fmrAgregarTrabajador ventana = new fmrAgregarTrabajador();
                ventana.setVisible(true);
                ventana.setSize(400,300);
                ventana.setLocationRelativeTo(null);
            }
        });


        // ===== BOTÓN TERMINAR PROGRAMA =====
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
