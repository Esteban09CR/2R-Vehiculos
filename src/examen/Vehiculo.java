
package examen;

abstract class Vehiculo {
    
    Vehiculo(){
        
    }
    
    private String estado;
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    private String placa;
        
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    private String vin;
        
    public String getVin() {
        return vin;
    }
    
    public void setVin(String vin) {
        this.vin = vin;
    }

    private String marca;
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }

    private String modelo;
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    private String ano;
        
    public String getAno() {
        return ano;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }

    private String cilindraje;
    
    public String getCilindraje() {
        return cilindraje;
    }
    
    public void setCilindraje(String cilindraje) {
        this.cilindraje = cilindraje;
    }

    private String traccion;
        
    public String getTraccion() {
        return traccion;
    }
    
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
}
