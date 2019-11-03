
package examen;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;


public class FormularioInformeVehiculo {

private void inicializarInformeVehiculo(){
    
   JRadioButton rbtn1=new JRadioButton("Reparado",true);
   JRadioButton rbtn2=new JRadioButton("En Reparacion",false);
   JRadioButton rbtn3=new JRadioButton("Mostrar",true);
   
   ButtonGroup grupo1 = new ButtonGroup();
   grupo1.add(rbtn1);
   grupo1.add(rbtn2);
   grupo1.add(rbtn3);
 
}
 } 
    

    
  