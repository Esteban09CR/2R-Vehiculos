
package examen;

public interface VehiculoEventListener {    
    void onVehicleAddAction(Vehiculo v);   
    void onVehicleEditAction(Vehiculo v); 
    void onVehicleSearchAction(String placa);
    void onVehicleDeleteAction(String placa);
}
