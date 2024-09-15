public class Aplicante {
    String codigoOferta;
    String calificaciones;
    String experiencia;
    String nombre;

    public Aplicante(String codigoOferta, String calificaciones, String experiencia, String nombre) {
        this.codigoOferta = codigoOferta;
        this.calificaciones = calificaciones;
        this.experiencia = experiencia;
        this.nombre = nombre;
    }
    public String getCodigoOferta() {
        return codigoOferta;
    }
    public void setCodigoOferta(String codigoOferta) {
        this.codigoOferta = codigoOferta;
    }
    public String getCalificaciones() {
        return calificaciones;
    }
    public void setCalificaciones(String calificaciones) {
        this.calificaciones = calificaciones;
    }
    public String getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
