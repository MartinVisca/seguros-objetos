package TPEspecial2018.filtros;

import TPEspecial2018.seguros.SeguroComun;

public class FPorMayor implements Filtro{
    private double umbral;

    public FPorMayor(double umbral){
        this.umbral = umbral;
    }

    public double getUmbral() {
        return umbral;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

    @Override
    public boolean cumple(SeguroComun s) {
        return s.getCosto() > this.umbral;
    }
}
