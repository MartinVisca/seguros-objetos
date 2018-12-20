package TPEspecial2018.filtros;

import TPEspecial2018.seguros.SeguroComun;

public class FAtributo implements Filtro{

    private String clave;
    private Object dato;

    public FAtributo(String clave, Object dato){
        this.clave = clave;
        this.dato = dato;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public boolean cumple(SeguroComun s) {
        if (s.containsAtrib(clave)) {
            return (s.getAtributo(clave).equals(dato));
        }
        return false;
    }
}
