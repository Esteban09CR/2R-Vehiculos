package examen;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FormularioAgregarVehiculo {
    private JPanel formularioAgregar = new JPanel(new BorderLayout(5,5));
    private JTextField vin = new JTextField(18);
    
    FormularioAgregarVehiculo(){
        inicializarFormulario();
    }

    private void inicializarFormulario() {
        JPanel labels = new JPanel(new GridLayout(0,1,5,5));
        formularioAgregar.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0,1,5,5));
        formularioAgregar.add(fields);

        labels.add(new JLabel("Numero de vin:", SwingConstants.TRAILING));
        fields.add(vin);
    }
    
    public void mostrarFormularioAgregar(){
        
    }
}
