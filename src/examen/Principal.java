package examen;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Principal extends JFrame implements VehiculoEventListener{
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();
    
    ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Principal(){
        initMenu();

        FormularioAgregarVehiculo agregar = new FormularioAgregarVehiculo();
        agregar.inicializarFormularioAgregar(panel1);
        agregar.setAddVehicleEventListener(this);
        
        FormularioEditarVehiculo editar = new FormularioEditarVehiculo();
        editar.inicializarFormularioEditar(panel2);
        editar.setEditVehicleEventListener(this);
        
        FormularioEstadoVehiculo estado = new FormularioEstadoVehiculo();
        estado.inicializarFormularioEstadoVehiculo(panel3);

        FormularioEliminarVehiculo eliminar = new FormularioEliminarVehiculo();
        eliminar.inicializarFormularioEliminar(panel4);
    }   

    @Override
    public void onVehicleAddAction(Vehiculo v) {
        vehiculos.add(v);
    }
    
    @Override
    public void onVehicleEditAction(Vehiculo v) {
        vehiculos.add(v);
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
                frame.setBounds(350, 350, 500, 350);
                frame.setVisible(true);

                int result = f_in.mostrarFormularioIngreso(frame);
                
                    if (result==JOptionPane.OK_OPTION) {

                    } else {
                        System.exit(0);
                    }
                }
            };
        SwingUtilities.invokeLater(r);
    }
}
