package TPEspecial2018.filtros;

import TPEspecial2018.seguros.SeguroComun;

public class FilAND implements Filtro{
    private Filtro f1;
    private Filtro f2;

    public FilAND(Filtro f1, Filtro f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    public Filtro getF1() {
        return f1;
    }

    public Filtro getF2() {
        return f2;
    }

    public void setF1(Filtro f1) {
        this.f1 = f1;
    }

    public void setF2(Filtro f2) {
        this.f2 = f2;
    }

    @Override
    public boolean cumple(SeguroComun s) {
        return f1.cumple(s) && f2.cumple(s);
    }
}
