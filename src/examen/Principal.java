/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author ralfaro
 */
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
        
        inicializarFormularioAgregar();        
        inicializarFormularioEditar();
        estadoVehiculo();
                
        setLayout(new BorderLayout());
    }

    private void inicializarFormularioAgregar() {
        
        JTextField vin = new JTextField(18);
        JTextField marca = new JTextField(25);
        JTextField modelo = new JTextField(25);
        JTextField anio = new JTextField(25);
        JTextField cilidraje = new JTextField(25);
        JTextField traccion = new JTextField(18);
        JTextField placa = new JTextField(18); 
        
        JButton agregar = new JButton("Agregar");
        
        
        JPanel labels = new JPanel(new GridLayout(0,1,0,12));
        panel1.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0,1,0,0));
        panel1.add(fields);

        labels.add(new JLabel("Numero VIN:", SwingConstants.TRAILING));        
        fields.add(vin);
        
        labels.add(new JLabel("Marca:", SwingConstants.TRAILING));        
        fields.add(marca);
        
        labels.add(new JLabel("Modelo:", SwingConstants.TRAILING));        
        fields.add(modelo);
        
        labels.add(new JLabel("Año:", SwingConstants.TRAILING));        
        fields.add(anio);
        
        labels.add(new JLabel("Cilindraje:", SwingConstants.TRAILING));        
        fields.add(cilidraje);
        
        labels.add(new JLabel("Traccion:", SwingConstants.TRAILING));        
        fields.add(traccion);
        
         labels.add(new JLabel("Placa:", SwingConstants.TRAILING));        
        fields.add(placa);
        
        labels.add(new JLabel("", SwingConstants.TRAILING));
        fields.add(agregar);
    }
    
    private void inicializarFormularioEditar() {
        
        JTextField vin = new JTextField(18); vin.setEditable(false);
        JTextField marca = new JTextField(25);
        JTextField modelo = new JTextField(25);
        JTextField anio = new JTextField(25);
        JTextField cilidraje = new JTextField(25);
        JTextField traccion = new JTextField(18);
        JTextField placa = new JTextField(18); 
        
        JButton modificar = new JButton("Modificar");
        
        
        JPanel labels = new JPanel(new GridLayout(0,1,0,12));
        panel2.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0,1,0,0));
        panel2.add(fields);

        labels.add(new JLabel("Numero VIN:", SwingConstants.TRAILING));        
        fields.add(vin);
        
        labels.add(new JLabel("Marca:", SwingConstants.TRAILING));        
        fields.add(marca);
        
        labels.add(new JLabel("Modelo:", SwingConstants.TRAILING));        
        fields.add(modelo);
        
        labels.add(new JLabel("Año:", SwingConstants.TRAILING));        
        fields.add(anio);
        
        labels.add(new JLabel("Cilindraje:", SwingConstants.TRAILING));        
        fields.add(cilidraje);
        
        labels.add(new JLabel("Traccion:", SwingConstants.TRAILING));        
        fields.add(traccion);
        
        labels.add(new JLabel("Placa:", SwingConstants.TRAILING));        
        fields.add(placa);
        
        labels.add(new JLabel("", SwingConstants.TRAILING));
        fields.add(modificar);
    }
    private void estadoVehiculo(){
        
          JTextField vin = new JTextField(18); vin.setEditable(true);
          JTextField placa = new JTextField(18); 
          
          JButton Consultar = new JButton("Consultar");
          
          JPanel labels = new JPanel(new GridLayout(0,1,0,12));
          panel3.add(labels, BorderLayout.LINE_START);
          JPanel fields = new JPanel(new GridLayout(0,1,0,0));
          panel3.add(fields);
          
          labels.add(new JLabel("Numero VIN:", SwingConstants.TRAILING));        
          fields.add(vin);
          
          labels.add(new JLabel("Placa:", SwingConstants.TRAILING));        
          fields.add(placa);
          
          labels.add(new JLabel("", SwingConstants.TRAILING));
          fields.add(Consultar);
          
          
        
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
