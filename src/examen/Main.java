
package examen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main {
    
    
    
    
    public static void main(String[] args) {
        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                JLabel l = new JLabel("<html>"
                        + "<body style='width: 300px; height: 175px;>",
                        SwingConstants.CENTER);

                JFrame f = new JFrame("2R Cars");

                JMenuBar menubar = new JMenuBar();

                JMenu archivo = new JMenu(" Archivo ");
                JMenuItem cerrarSesion = new JMenuItem(" Cerrar Sesion ");
                JMenuItem salir = new JMenuItem(" Salir ");

                archivo.add(cerrarSesion);
                archivo.add(salir);

                menubar.add(archivo);

                JMenu administracion = new JMenu(" Administracion ");

                JMenuItem agregarVehiculo = new JMenuItem("Agregar Vehiculo");
                JMenuItem editarVehiculo = new JMenuItem("Editar Vehiculo");
                JMenuItem estadoVehiculo = new JMenuItem("Estado del Vehiculo");
                JMenuItem eliminarVehiculo = new JMenuItem("Eliminar Vehiculo");

                administracion.add(agregarVehiculo);
                administracion.add(editarVehiculo);
                administracion.add(estadoVehiculo);
                administracion.add(eliminarVehiculo);

                menubar.add(administracion);

                JMenu informeVehiculo = new JMenu("Informe del Vehiculo");

                JMenuItem todoslosVehiculosmantenimiento = new JMenuItem(" Vehiculos en Mantenimiento ");
                JMenuItem todosvehiculosentregados = new JMenuItem(" Vehiculos Entregados ");

                informeVehiculo.add(todoslosVehiculosmantenimiento);
                informeVehiculo.add(todosvehiculosentregados);

                menubar.add(informeVehiculo);

                f.setJMenuBar(menubar);

                f.add(l);
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // ensures the minimum size is enforced.
                f.setMinimumSize(f.getSize());
                f.setVisible(true);

                FormularioIngreso lif = new FormularioIngreso();
                int result = lif.displayLoginForm(f);
                // do the approrpaite action for this result
                if (result==JOptionPane.OK_OPTION) {
                    l.setText("Welcome " + lif.getUserID());
                } else {
                    l.setText("This application requires authentication!");
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
