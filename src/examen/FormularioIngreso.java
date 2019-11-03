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
    private JPanel loginForm = new JPanel(new BorderLayout(5,5));
    private JTextField userID = new JTextField(12);
    private JPasswordField password = new JPasswordField(8);

    FormularioIngreso() {
        initializeLoginForm();
    }

    /** 
     * Displays the log-in form inside a confirmation option pane. 
     * The result (OK/Cancel) of the option pane is returned for inspection.
     */
    public final int displayLoginForm(Component parent) {
        return JOptionPane.showConfirmDialog(
                parent, 
                loginForm, 
                "Log In", 
                JOptionPane.OK_CANCEL_OPTION, 
                JOptionPane.QUESTION_MESSAGE);
    }

    private final void initializeLoginForm() {
        JPanel labels = new JPanel(new GridLayout(0,1,5,5));
        loginForm.add(labels, BorderLayout.LINE_START);
        JPanel fields = new JPanel(new GridLayout(0,1,5,5));
        loginForm.add(fields);

        labels.add(new JLabel("User ID:", SwingConstants.TRAILING));
        labels.add(new JLabel("Password:", SwingConstants.TRAILING));

        JPanel userIdConstrain = new JPanel(
                new FlowLayout(FlowLayout.LEADING));
        userIdConstrain.add(userID);
        fields.add(userIdConstrain);

        JPanel passwordConstrain = new JPanel(
                new FlowLayout(FlowLayout.LEADING));
        passwordConstrain.add(password);
        fields.add(passwordConstrain);
    }

    public final String getUserID() {
        return userID.getText();
    }

    public final char[] getPasword() {
        return password.getPassword();
    }
}
