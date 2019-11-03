/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ralfaro
 */
public class FormularioEstadoVehiculo {
    
    FormularioEstadoVehiculo(){
        
    }
    
    public void inicializarFormularioEstadoVehiculo(JPanel panel){
        
          JTextField vin = new JTextField(18); vin.setEditable(true);
          JTextField placa = new JTextField(18); 
          
          JButton Consultar = new JButton("Consultar");
          
          JPanel labels = new JPanel(new GridLayout(0,1,0,12));
          panel.add(labels, BorderLayout.LINE_START);
          JPanel fields = new JPanel(new GridLayout(0,1,0,0));
          panel.add(fields);
          
          labels.add(new JLabel("Numero VIN:", SwingConstants.TRAILING));        
          fields.add(vin);
          
          labels.add(new JLabel("Placa:", SwingConstants.TRAILING));        
          fields.add(placa);
          
          labels.add(new JLabel("", SwingConstants.TRAILING));
          fields.add(Consultar);
    }
    
}
