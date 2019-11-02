
package examen;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class Main {
    
    public static void main(String[] args) {
        JFrame f = new JFrame("Text Field Examples");
        f.getContentPane().setLayout(new FlowLayout());
                    
        JMenuBar menubar = new JMenuBar();
        
        JMenu archivo = new JMenu("Archivo");
        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
        JMenuItem salir = new JMenuItem("Salir");
        
        archivo.add(cerrarSesion);
        archivo.add(salir);
        
        menubar.add(archivo);
        
        f.setJMenuBar(menubar);
		   
        f.pack();
        f.setVisible(true);
    }
    
}
