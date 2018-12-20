package TPEspecial2018.seguros;

import TPEspecial2018.filtros.Filtro;

import java.util.*;

public class SeguroComun extends TipoSeguro{
    private HashMap<String,Object> atributos;
    private double costo;

    public SeguroComun(String tipoPoliza, int numPoliza, double costo) {
        super(tipoPoliza, numPoliza);
        this.atributos = new HashMap<>();
        this.costo = costo;
    }

    public Object getAtributo(String atributo) {
        if (this.containsAtrib(atributo))
            return (atributos.get(atributo));
        return null;
    }

    public void setAtributo(String atributo, Object valor){
        if (this.atributos.containsKey(atributo))
            this.atributos.replace(atributo, valor);
    }

    public Iterator<String> getAtributos(){
        return this.atributos.keySet().iterator();
    }

    @Override
    public double getCosto() {
        return this.costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void addAtributo(String atributo, Object valor){
        this.atributos.put(atributo, valor);
    }

    public void removeAtributo(String atributo){
        if (this.atributos.containsKey(atributo))
            this.atributos.remove(atributo);
    }

    public boolean containsAtrib(Object atributo) {
        return (atributos.containsKey(atributo));
    }

    @Override
    public Vector<SeguroComun> filtrarSeguros(Filtro f) {
        Vector<SeguroComun> salida = new Vector<>();
        if (f.cumple(this))
            salida.add(this);
        return salida;
    }

    @Override
    public Vector<SeguroComun> getSeguros() {
        Vector<SeguroComun> salida = new Vector<>();
        salida.add(this);
        return salida;
    }
}
