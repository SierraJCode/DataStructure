package Usuario;

public class Direccion {
    public String calle;
    public String nomenclatura;
    public String barrio;
    public String ciudad;
    public String urbanizacion;
    public String numApto;
    public Direccion(String calle, String nomenclatura, String barrio, String ciudad, String urbanizacion,
            String numApto) {
        this.calle = calle;
        this.nomenclatura = nomenclatura;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.urbanizacion = urbanizacion;
        this.numApto = numApto;
    }
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public String getNomenclatura() {
        return nomenclatura;
    }
    public void setNomenclatura(String nomenclatura) {
        this.nomenclatura = nomenclatura;
    }
    public String getBarrio() {
        return barrio;
    }
    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getUrbanizacion() {
        return urbanizacion;
    }
    public void setUrbanizacion(String urbanizacion) {
        this.urbanizacion = urbanizacion;
    }
    public String getNumApto() {
        return numApto;
    }
    public void setNumApto(String numApto) {
        this.numApto = numApto;
    }

    
    
}
