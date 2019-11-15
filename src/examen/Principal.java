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
    ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();

    public Principal(){
        
        Usuarios u1 = new Usuarios();
        u1.setUsuario("Esteban");
        u1.setContrasena("123");
        
        Usuarios u2 = new Usuarios();
        u1.setUsuario("Invitado");
        u1.setContrasena("123");
        
        usuarios.add(u1);
        usuarios.add(u2);
        
        initMenu();

        FormularioAgregarVehiculo agregar = new FormularioAgregarVehiculo();
        agregar.inicializarFormularioAgregar(panel1);
        agregar.setAddVehicleEventListener(this);
        
        FormularioEditarVehiculo editar = new FormularioEditarVehiculo();
        editar.inicializarFormularioEditar(panel2, null);
        editar.setEditVehicleEventListener(this);
        
        FormularioEstadoVehiculo estado = new FormularioEstadoVehiculo();
        estado.inicializarFormularioEstadoVehiculo(panel3);

        FormularioEliminarVehiculo eliminar = new FormularioEliminarVehiculo();
        eliminar.inicializarFormularioEliminar(panel4);
        eliminar.setEliminarVehicleEventListener(this);
    }   

    @Override
    public void onVehicleAddAction(Vehiculo v) {
        vehiculos.add(v);
    }
    
    @Override
    public void onVehicleDeleteAction(String placa){
        for (int i =0; i < vehiculos.size(); i++){
            if(vehiculos.get(i).getPlaca().equals(placa)){
                vehiculos.remove(i); 
            }
        }
    }
    
    @Override
    public void onVehicleEditAction(Vehiculo v) {
        Vehiculo veh = null;
        for(int i = 0; i<vehiculos.size(); i++){
            if(vehiculos.get(i).getPlaca().equals(v.getPlaca())){
                veh = vehiculos.get(i);
            }
        }
        
        veh.setMarca(v.getMarca());
        
    }
    
    @Override
    public void onVehicleSearchAction(String placa){
        Vehiculo v = null;
        for(int i = 0; i<vehiculos.size(); i++){
            if(vehiculos.get(i).getPlaca().equals(placa)){
                v = vehiculos.get(i);
            }
        }
        
        if(v != null){
            FormularioEditarVehiculo editar = new FormularioEditarVehiculo();
            editar.inicializarFormularioEditar(panel2, v);
            getContentPane().removeAll();
            getContentPane().add(panel2, BorderLayout.CENTER);
            getContentPane().doLayout();
            update(getGraphics());
            panel2.validate();
            panel2.repaint();
        }
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
                frame.setBounds(1024, 400,1024,400);
                frame.setVisible(true);

                int result = f_in.mostrarFormularioIngreso(frame);
                
                    if (result==JOptionPane.OK_OPTION) {
                        String usuario = f_in.getUserID();
                        String con = f_in.getPasword().toString();
                        
                        while(!(usuario.equals("Esteban") || usuario.equals("Invitado")) && !con.equals("123"))
                        {
                            JOptionPane.showMessageDialog(frame, "Error en credenciales");
                            result = f_in.mostrarFormularioIngreso(frame);
                            
                            usuario = f_in.getUserID();
                            con = f_in.getPasword().toString();
                            
                            if (result==JOptionPane.CANCEL_OPTION) {
                                System.exit(0);
                            }                            
                        }                        
                    } else {
                        System.exit(0);
                    }
                }
            };
        SwingUtilities.invokeLater(r);
    }
}
