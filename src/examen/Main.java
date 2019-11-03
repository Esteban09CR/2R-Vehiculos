
package examen;

import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        //crea un hilo de ejecucion para mostrar la pantalla de ingreso
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //etiqueta para mostrar mensaje
                JLabel l = new JLabel("<html>"
                        + "<body style='width: 300px; height: 175px;>",
                        SwingConstants.CENTER);
                
                //crea una instancia del formulario de ingreso
                FormularioIngreso f_in = new FormularioIngreso();
                
                //crea una instancia del formulario principal
                JFrame f = new JFrame("2R Cars");

                JMenuBar menubar = new JMenuBar();

                JMenu archivo = new JMenu("Archivo");
                
                JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
                //maneja el evento del menu cerrar sesion
                cerrarSesion.addActionListener((ActionEvent ev) -> {
                    int result = f_in.mostrarFormularioIngreso(f);
                    if (result==JOptionPane.OK_OPTION) {
                        l.setText("Bienvenido " + f_in.getUserID() + " seleccione una opcion del menu.");
                    } else {
                        System.exit(0);
                    }
                });
                
                JMenuItem salir = new JMenuItem("Salir");
                //maneja el evento de salir
                salir.addActionListener((ActionEvent ev) -> {
                    System.exit(0);
                });

                archivo.add(cerrarSesion);
                archivo.add(salir);

                menubar.add(archivo);

                JMenu administracion = new JMenu("Administracion");

                JMenuItem agregarVehiculo = new JMenuItem("Agregar Vehiculo");
                  agregarVehiculo.addActionListener((ActionEvent ev) -> {
                     l.setText("Agregue Vehiculo ");
                    
                });
                JMenuItem editarVehiculo = new JMenuItem("Editar Vehiculo");
                editarVehiculo.addActionListener((ActionEvent ev) -> {
                     l.setText("Edite el Vehiculo que desea");
                      });
                     
                JMenuItem estadoVehiculo = new JMenuItem("Estado del Vehiculo");
                estadoVehiculo.addActionListener((ActionEvent ev) -> {
                     l.setText("Cual es el estado del vehiculo?");
                      });
                
                JMenuItem eliminarVehiculo = new JMenuItem("Eliminar Vehiculo");
                eliminarVehiculo.addActionListener((ActionEvent ev) -> {
                     l.setText("Cual Vehiculo desea eliminar?");
                 });

                administracion.add(agregarVehiculo);
                administracion.add(editarVehiculo);
                administracion.add(estadoVehiculo);
                administracion.add(eliminarVehiculo);

                menubar.add(administracion);

                JMenu informeVehiculo = new JMenu("Informe del Vehiculo");
            
                JMenuItem todoslosVehiculosmantenimiento = new JMenuItem("Vehiculos en Mantenimiento");
                    informeVehiculo.addActionListener((ActionEvent ev) -> {
                     l.setText("Que tiene el vehiculo");
                 });
                JMenuItem todosvehiculosentregados = new JMenuItem("Vehiculos Entregados");
                 informeVehiculo.addActionListener((ActionEvent ev) -> {
                     l.setText("Cuales Vehiculos se han entregado?");
                 });

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

                int result = f_in.mostrarFormularioIngreso(f);
                // do the approrpaite action for this result
                if (result==JOptionPane.OK_OPTION) {
                    l.setText("Bienvenido " + f_in.getUserID() + " seleccione una opcion del menu.");
                } else {
                    System.exit(0);
                }
            }
        };
        SwingUtilities.invokeLater(r);
    }
}
