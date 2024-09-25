package Usuario;

public class Usuario {
    private long id;
    private String nombre;
    private String fechaNacimiento;
    private String ciudadNacimiento;
    private String telefono;
    private String correoElectronico;
    private Direccion direccion;

    public Usuario(long id, String nombre, String fechaNacimiento, String ciudadNacimiento,
                   String telefono, String correoElectronico, Direccion direccion) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudadNacimiento = ciudadNacimiento;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    public Usuario(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getCiudadNacimiento() {
        return ciudadNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setCiudadNacimiento(String ciudadNacimiento) {
        this.ciudadNacimiento = ciudadNacimiento;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        if (fechaNacimiento == null) {
            return id + " " + nombre;
        }else{
            return  id + ' ' + nombre + ' ' + fechaNacimiento + ' ' + ciudadNacimiento + ' ' + telefono + ' ' + correoElectronico + ' ' + direccion;
        }
    }

}

