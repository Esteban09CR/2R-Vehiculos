
package examen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormularioEliminarVehiculo {
    
    public void inicializarFormularioEliminar(JPanel panel){
          
          JTextField vin = new JTextField(18); vin.setEditable(true);
          JTextField placa = new JTextField(18); 
          
          JButton Eliminar = new JButton("Eliminar");
        Eliminar.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null, "Vehiculo Eliminado con exito");
        });
          
        JPanel labels = new JPanel(new GridLayout(0,1,0,12));
          panel.add(labels, BorderLayout.LINE_START);
         JPanel fields = new JPanel(new GridLayout(0,1,0,0));
          panel.add(fields);
          
          labels.add(new JLabel("Numero VIN:", SwingConstants.TRAILING));        
          fields.add(vin);
          
          labels.add(new JLabel("Placa:", SwingConstants.TRAILING));        
          fields.add(placa);
          
          labels.add(new JLabel("", SwingConstants.TRAILING));
          fields.add(Eliminar);
          
          
    }
     public String mensaje(){
         JOptionPane.showMessageDialog(null,"Eliminado");
        return null;
         
     }
  
   
    
    
}
