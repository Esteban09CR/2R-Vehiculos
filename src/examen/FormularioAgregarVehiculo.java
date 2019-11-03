package examen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormularioAgregarVehiculo {
    
    private VehiculoEventListener vehiculoEventListener;
    
    FormularioAgregarVehiculo(){
    }
    
    public void setAddVehicleEventListener (VehiculoEventListener listener) {
        vehiculoEventListener = listener;
    }

    public void inicializarFormularioAgregar(JPanel panel) {
        
        JTextField vin = new JTextField(18);
        JTextField marca = new JTextField(25);
        JTextField modelo = new JTextField(25);
        JTextField anio = new JTextField(25);
        JTextField cilidraje = new JTextField(25);
        JTextField traccion = new JTextField(18);
        JTextField placa = new JTextField(18); 
        
        
        ButtonGroup bg = new ButtonGroup();
        
        JRadioButton gasolina = new JRadioButton("Gasolina");
        JRadioButton diesel = new JRadioButton("Diesel");
        
        JButton agregar = new JButton("Agregar");
        agregar.addActionListener((ActionEvent e) -> {
            if(vehiculoEventListener!=null)
            {
                Vehiculo v = new VehiculoDiesel();
                v.setVin(vin.getText());
                v.setAno(anio.getText());
                
                vehiculoEventListener.onVehicleAddAction(v);
            }
        });
        
        
        JPanel labels = new JPanel(new GridLayout(10,1,0,15));
        panel.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0,1,0,0));
        panel.add(fields);

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
        
     
        bg.add(gasolina);
        bg.add(diesel);
        fields.add(gasolina);
        fields.add(diesel);
        
        labels.add(new JLabel("", SwingConstants.TRAILING));
        fields.add(agregar);
        
        
        
    }
}
