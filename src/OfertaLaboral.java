import java.util.Random;

public class OfertaLaboral {
    String industria;
    String ubicacion;
    String tipoContrato;
    String oferta;
    String codigoOferta;
    
    // constructor
    public OfertaLaboral() {
    }

    // constructor
    public OfertaLaboral(String industria, String ubicacion, String tipoContrato, String oferta) {
        this.industria = industria;
        this.ubicacion = ubicacion;
        this.tipoContrato = tipoContrato;
        this.oferta = oferta;

        Random rand = new Random();
        int random = rand.nextInt(1000);   
        this.codigoOferta = "Oferta" + random; // Para identificar la oferta
    }


    public String getIndustria() {
        return industria;
    }
    public void setIndustria(String industria) {
        this.industria = industria;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getTipoContrato() {
        return tipoContrato;
    }
    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    public String getOferta() {
        return oferta;
    }
    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getCodigoOferta() {
        return codigoOferta;
    }

    public void setCodigoOferta(String codigoOferta) {
        this.codigoOferta = codigoOferta;
    }
}
