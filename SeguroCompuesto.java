package TPEspecial2018.seguros;

import TPEspecial2018.filtros.Filtro;

import java.util.*;

public class SeguroCompuesto extends TipoSeguro{

    protected double porcentajeAsociado;
    protected Vector<TipoSeguro> seguros;
    public final static int PORCENTUAL = 100;
    protected String cliente;

    public SeguroCompuesto(String tipoPoliza, int nroPoliza, double porcentaje) {
        super(tipoPoliza, nroPoliza);
        this.porcentajeAsociado = porcentaje;
        this.seguros = new Vector<>();
    }

    public double getPorcentajeAsociado() {
        return this.porcentajeAsociado;
    }

    public void setPorcentajeAsociado(int porcentaje) {
        this.porcentajeAsociado = porcentaje;
    }

    public void addSeguro(TipoSeguro ts){
        if (!this.seguros.contains(ts))
            this.seguros.add(ts);
    }

    public void removeSeguro(TipoSeguro ts){
        if (this.seguros.contains(ts)){
            this.seguros.remove(ts);
        }
    }

    public Vector<SeguroComun> getSeguros(){
        Vector<SeguroComun> salida = new Vector<>();
        for (int i = 0; i < this.seguros.size(); i++){
            TipoSeguro ts = this.seguros.elementAt(i);
            salida.addAll(ts.getSeguros());
        }
        return salida;
    }

    @Override
    public Vector<SeguroComun> filtrarSeguros(Filtro f) {
        Vector<SeguroComun> salida = new Vector<>();
        for (int i = 0; i < this.seguros.size(); i++){
            TipoSeguro ts = this.seguros.elementAt(i);
            salida.addAll(ts.filtrarSeguros(f));
        }
        return salida;
    }

    @Override
    public double getCosto() {
        double suma = 0;
        for (int i = 0; i < this.seguros.size(); i++){
            TipoSeguro ts = this.seguros.elementAt(i);
            suma += ts.getCosto();
        }
        return suma - suma * this.porcentajeAsociado / PORCENTUAL; 
    }
}
