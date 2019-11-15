
package examen;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class FormularioInformeVehiculo {
    
    private VehiculoEventListener vehiculoEventListener;
    
    FormularioInformeVehiculo(){
        
    }
    
    public void setReportVehicleEventListener (VehiculoEventListener listener) {
        vehiculoEventListener = listener;
    }

    public void inicializarInformeVehiculo(JPanel panel, ArrayList<Vehiculo> veh){
        JLabel mant = new JLabel();
        JLabel ent = new JLabel();
        
        String m = new String();
        String e = new String();
        
        for (int i = 0; i< veh.size(); i++){
            if(veh.get(i).mantenimiento){
                m += veh.get(i).getPlaca() + ", ";
            } else{
                e += veh.get(i).getPlaca() + ", ";
            }
        }
        
        mant.setText("balghaha");
        ent.setText(e);
    }
} 
    

    
  