package TPEspecial2018.seguros;

import TPEspecial2018.filtros.Filtro;

import java.util.Vector;

public abstract class TipoSeguro {
    private String tipoPoliza;
    private int nroPoliza;

    TipoSeguro(String tipoPoliza, int nroPoliza){
        this.tipoPoliza = tipoPoliza;
        this.nroPoliza = nroPoliza;
    }

    public int getNroPoliza() {
        return nroPoliza;
    }

    public String getTipoPoliza() {
        return tipoPoliza;
    }

    public void setNroPoliza(int nroPoliza) {
        this.nroPoliza = nroPoliza;
    }

    public void setTipoPoliza(String tipoPoliza) {
        this.tipoPoliza = tipoPoliza;
    }

    public abstract Vector<SeguroComun> filtrarSeguros(Filtro f);

    public abstract double getCosto();

    public abstract Vector<SeguroComun> getSeguros();
}
