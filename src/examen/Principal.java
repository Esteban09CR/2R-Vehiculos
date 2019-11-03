package examen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.NumberFormatter;

public class Principal extends JFrame{
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();

    public Principal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initMenu();

        FormularioAgregarVehiculo agregar = new FormularioAgregarVehiculo();
        agregar.inicializarFormularioAgregar(panel1);
        
        FormularioEditarVehiculo editar = new FormularioEditarVehiculo();
        editar.inicializarFormularioEditar(panel2);
        
        FormularioEstadoVehiculo estado = new FormularioEstadoVehiculo();
        estado.inicializarFormularioEstadoVehiculo(panel3);

        FormularioEliminarVehiculo eliminar = new FormularioEliminarVehiculo();
        eliminar.inicializarFormularioEliminar(panel4);
                
        setLayout(new BorderLayout());
    }   

    private class MenuAction implements ActionListener {
        private JPanel panel;
        private MenuAction(JPanel pnl) {
            this.panel = pnl;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            changePanel(panel);
        }
    }
    
    private void initMenu() {
        JMenuBar menubar = new JMenuBar();        

        JMenu archivo = new JMenu("Archivo");

        JMenuItem cerrarSesion = new JMenuItem("Cerrar Sesion");
        //maneja el evento del menu cerrar sesion
        cerrarSesion.addActionListener((ActionEvent ev) -> {
            System.exit(0);
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
        JMenuItem editarVehiculo = new JMenuItem("Editar Vehiculo");
        JMenuItem estadoVehiculo = new JMenuItem("Estado del Vehiculo");
        JMenuItem eliminarVehiculo = new JMenuItem("Eliminar Vehiculo");

        administracion.add(agregarVehiculo);
        administracion.add(editarVehiculo);
        administracion.add(estadoVehiculo);
        administracion.add(eliminarVehiculo);

        menubar.add(administracion);

        JMenu informeVehiculo = new JMenu("Informe del Vehiculo");

        JMenuItem todoslosVehiculosmantenimiento = new JMenuItem("Vehiculos en Mantenimiento");
        JMenuItem todosvehiculosentregados = new JMenuItem("Vehiculos Entregados");

        informeVehiculo.add(todoslosVehiculosmantenimiento);
        informeVehiculo.add(todosvehiculosentregados);

        menubar.add(informeVehiculo);        
        
        setJMenuBar(menubar);
        
        agregarVehiculo.addActionListener(new MenuAction(panel1));
        editarVehiculo.addActionListener(new MenuAction(panel2));
        estadoVehiculo.addActionListener(new MenuAction(panel3));
        eliminarVehiculo.addActionListener(new MenuAction(panel4));

    }

    private void changePanel(JPanel panel) {
        getContentPane().removeAll();
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().doLayout();
        update(getGraphics());
        panel.validate();
        panel.repaint();
    }

    public static void main(String[] args) {
        //crea un hilo de ejecucion para mostrar la pantalla de ingreso
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //crea una instancia del formulario de ingreso
                FormularioIngreso f_in = new FormularioIngreso();

                Principal frame = new Principal();
                frame.setBounds(300, 300, 500, 300);
                frame.setVisible(true);

                int result = f_in.mostrarFormularioIngreso(frame);
                    // do the approrpaite action for this result
                    if (result==JOptionPane.OK_OPTION) {

                    } else {
                        System.exit(0);
                    }
                }
            };
        SwingUtilities.invokeLater(r);
    }
}
