
package examen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormularioEditarVehiculo {
    
    private VehiculoEventListener vehiculoEventListener;
    
    FormularioEditarVehiculo(){
        
    }
    
    public void setEditVehicleEventListener (VehiculoEventListener listener) {
        vehiculoEventListener = listener;
    }
    
    public void inicializarFormularioEditar(JPanel panel) {
        
        JTextField vin = new JTextField(18); vin.setEditable(false);
        JTextField marca = new JTextField(25);
        JTextField modelo = new JTextField(25);
        JTextField anio = new JTextField(25);
        JTextField cilidraje = new JTextField(25);
        JTextField traccion = new JTextField(18);
        JTextField placa = new JTextField(18); 
        
        JButton modificar = new JButton("Modificar");
        modificar.addActionListener((ActionEvent e) -> {
            if(vehiculoEventListener!=null)
            {
                Vehiculo v = new VehiculoDiesel();
                v.setVin(vin.getText());
                v.setAno(anio.getText());
                
                vehiculoEventListener.onVehicleEditAction(v);
            }
        });
        
        JPanel labels = new JPanel(new GridLayout(0,1,0,12));
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
        
        labels.add(new JLabel("", SwingConstants.TRAILING));
        fields.add(modificar);
    }
}
