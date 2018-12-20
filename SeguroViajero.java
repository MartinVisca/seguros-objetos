package TPEspecial2018.seguros;

import TPEspecial2018.filtros.Filtro;

import java.time.LocalDate;
import java.util.Vector;

public class SeguroViajero extends SeguroCompuesto{

    private LocalDate fechaini, fechafin;
    public final static int INACTIVO = 0;

    public SeguroViajero(String tipoPoliza, int nroPoliza, double porcentaje, String fechaini, String fechafin) {
        super(tipoPoliza, nroPoliza, porcentaje);
        this.fechaini = LocalDate.parse(fechaini);
        this.fechafin = LocalDate.parse(fechafin);
    }

    public String getFechaini() {
        return this.fechaini.toString();
    }

    public void setFechaini(String fechaini) {
        this.fechaini = LocalDate.parse(fechaini);
    }

    public String getFechafin() {
        return this.fechafin.toString();
    }

    public void setFechafin(String fechafin) {
        this.fechafin = LocalDate.parse(fechafin);
    }

    private boolean isActivo(){
        LocalDate hoy = LocalDate.now();
        return this.fechafin.isAfter(hoy) && this.fechaini.isBefore(hoy);
    }

    @Override
    public Vector<SeguroComun> filtrarSeguros(Filtro f) {
        Vector<SeguroComun> salida = new Vector<>();
        if (this.isActivo())
            salida = super.filtrarSeguros(f);
        return salida;
    }

    @Override
    public double getCosto() {
        if (this.isActivo()){
            int suma = 0;
            for (int i = 0; i < this.seguros.size(); i++){
                TipoSeguro ts = this.seguros.elementAt(i);
                suma += ts.getCosto();
            }
            return suma + suma * this.porcentajeAsociado / PORCENTUAL;
        }
        else
            return INACTIVO;
    }
}
