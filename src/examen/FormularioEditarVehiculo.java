
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
    
    public void inicializarFormularioEditar(JPanel panel, Vehiculo vehiculo) {
        
        JTextField vin = new JTextField(18); vin.setEditable(false);
        JTextField marca = new JTextField(25);
        JTextField modelo = new JTextField(25);
        JTextField anio = new JTextField(25);
        JTextField cilindraje = new JTextField(25);
        JTextField traccion = new JTextField(18);
        JTextField placa = new JTextField(18); 
       
        
        if(vehiculo != null){
            vin.setText(vehiculo.getVin());
            placa.setText(vehiculo.getPlaca());
            cilindraje.setText(vehiculo.getCilindraje());
        }
        
        JButton buscar = new JButton("Buscar");
        buscar.addActionListener((ActionEvent e) -> {
            if(vehiculoEventListener!=null)
            {
                vehiculoEventListener.onVehicleSearchAction(placa.getText());
            }
        });
        
        JButton modificar = new JButton("Modificar");
        modificar.addActionListener((ActionEvent e) -> {
            if(vehiculoEventListener!=null)
            {
                Vehiculo v = new VehiculoDiesel();
                v.setVin(vin.getText());
                v.setAno(anio.getText());
                v.setCilindraje(cilindraje.getText());
                v.setMarca(marca.getText());
                v.setModelo(modelo.getText());
                v.setPlaca(placa.getText());
                v.setTraccion(traccion.getText());
               

                
                
                
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
        fields.add(cilindraje);
        
        labels.add(new JLabel("Traccion:", SwingConstants.TRAILING));        
        fields.add(traccion);
        
        labels.add(new JLabel("Placa:", SwingConstants.TRAILING));        
        fields.add(placa);
        
        labels.add(new JLabel("", SwingConstants.TRAILING));
        fields.add(buscar);
        
        labels.add(new JLabel("", SwingConstants.TRAILING));
        fields.add(modificar);
    }
    
    public void llenarFormulario(Vehiculo v){
        
    }
}
