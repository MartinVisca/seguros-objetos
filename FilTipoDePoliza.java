package TPEspecial2018.filtros;

import TPEspecial2018.seguros.SeguroComun;

public class FilTipoDePoliza implements Filtro{
    private String comparador;

    public FilTipoDePoliza(String comparador){
        this.comparador = comparador;
    }

    public String getComparador() {
        return comparador;
    }

    public void setComparador(String comparador) {
        this.comparador = comparador;
    }

    @Override
    public boolean cumple(SeguroComun s) {
        return s.getTipoPoliza().equals(this.comparador);
    }
}
