
package examen;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Main {
    
    public static void main(String[] args) {
        JFrame f = new JFrame(" 2R Cars ");
        f.getContentPane().setLayout(new FlowLayout());
                    
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
        
		   
        f.pack();
        f.setVisible(true);
    }
    
}
