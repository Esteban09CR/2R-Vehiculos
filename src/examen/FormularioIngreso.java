/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author ralfaro
 */
public class FormularioIngreso {
    private JPanel formularioIngreso = new JPanel(new BorderLayout(5,5));
    private JTextField idUsuario = new JTextField(12);
    private JPasswordField password = new JPasswordField(8);

    FormularioIngreso() {
        inicializarFormularioIngreso();
    }

    /** 
     * Displays the log-in form inside a confirmation option pane. 
     * The result (OK/Cancel) of the option pane is returned for inspection.
     */
    public final int mostrarFormularioIngreso(Component parent) {
        return JOptionPane.showConfirmDialog(
                parent, 
                formularioIngreso, 
                "Ingreso", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
    }

    private void inicializarFormularioIngreso() {
        JPanel labels = new JPanel(new GridLayout(0,1,5,5));
        formularioIngreso.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0,1,5,5));
        formularioIngreso.add(fields);

        labels.add(new JLabel("Usuario:", SwingConstants.TRAILING));
        labels.add(new JLabel("Contraseña:", SwingConstants.TRAILING));

        JPanel userIdConstrain = new JPanel(
                new FlowLayout(FlowLayout.LEADING));
        userIdConstrain.add(idUsuario);
        fields.add(userIdConstrain);

        JPanel passwordConstrain = new JPanel(
                new FlowLayout(FlowLayout.LEADING));
        passwordConstrain.add(password);
        fields.add(passwordConstrain);
    }

    public final String getUserID() {
        return idUsuario.getText();
    }

    public final char[] getPasword() {
        return password.getPassword();
    }
}
