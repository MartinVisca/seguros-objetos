package TPEspecial2018.main;

import TPEspecial2018.filtros.FAtributo;
import TPEspecial2018.filtros.FPorMayor;
import TPEspecial2018.filtros.FilAND;
import TPEspecial2018.filtros.FilTipoDePoliza;
import TPEspecial2018.seguros.SeguroCompuesto;
import TPEspecial2018.seguros.SeguroComun;
import TPEspecial2018.seguros.SeguroViajero;

import java.util.Iterator;
import java.util.Vector;

public class Main {
    public static void main (String[] args) {

        //Guia de pruebas; punto 1

        SeguroComun seguro1 = new SeguroComun("Empleado", 2324, 1200);
        seguro1.addAtributo("Nombre y apellido", "Lionel Messi");
        seguro1.addAtributo("Club actual", "Barcelona");
        seguro1.addAtributo("Puesto", "Delantero");
        seguro1.addAtributo("Edad", 30);

        SeguroComun seguro2 = new SeguroComun("Empleado", 2325, 1000);
        seguro2.addAtributo("Nombre y apellido", "Gonzalo Higuain");
        seguro2.addAtributo("Club actual", "Juventus");
        seguro2.addAtributo("Puesto", "Delantero");
        seguro2.addAtributo("Edad", 30);

        SeguroComun seguro3 = new SeguroComun("Hogar", 5632, 234);
        seguro3.addAtributo("Direccion", "España 1234");
        seguro3.addAtributo("Edad", 47);
        seguro3.addAtributo("Tipo de hogar", "Casa");

        SeguroComun seguro4 = new SeguroComun("Automotor", 4564, 187);
        seguro4.addAtributo("Modelo", 2014);
        seguro4.addAtributo("Edad", 4);
        seguro4.addAtributo("Tipo de auto", "4 puertas");

        SeguroComun seguro5 = new SeguroComun("Empleado", 2354, 1100);
        seguro5.addAtributo("Nombre y apellido", "Sergio Aguero");
        seguro5.addAtributo("Club actual", "Manchester City");
        seguro5.addAtributo("Puesto", "Delantero");
        seguro5.addAtributo("Edad", 29);

        SeguroComun seguro6 = new SeguroComun("Empleado", 5678, 350);
        seguro6.addAtributo("Nombre y apellido", "Jorge Sampaoli");
        seguro6.addAtributo("Puesto", "Tecnico");
        seguro6.addAtributo("Edad", 58);

        SeguroComun seguro7 = new SeguroComun("Empleado", 1214, 450);
        seguro7.addAtributo("Nombre y apellido", "Cristian Ansaldi");
        seguro7.addAtributo("Club actual", "Torino");
        seguro7.addAtributo("Puesto", "Defensor");
        seguro7.addAtributo("Edad", 31);

        SeguroComun seguro8 = new SeguroComun("Automotor", 2160, 194);
        seguro8.addAtributo("Modelo", 2008);
        seguro8.addAtributo("Edad", 10);
        seguro8.addAtributo("Tipo de auto", "Coupe");

        //Punto 2

        SeguroCompuesto seguro9 = new SeguroCompuesto("Integrador", 4747, 20);
        seguro9.addSeguro(seguro4);
        seguro9.addSeguro(seguro8);

        SeguroViajero seguro10 = new SeguroViajero("Especial viajero", 4748, 20,"2018-06-14", "2018-07-15");
        seguro10.addSeguro(seguro1);
        seguro10.addSeguro(seguro2);
        seguro10.addSeguro(seguro5);
        seguro10.addSeguro(seguro6);
        seguro10.addSeguro(seguro7);

        SeguroCompuesto seguro11 = new SeguroCompuesto("Colectivo", 4749, 17.5);
        seguro11.addSeguro(seguro6);
        seguro11.addSeguro(seguro8);
        seguro11.addSeguro(seguro3);

        //Punto 3

        System.out.println("Seguro " + seguro9.getTipoPoliza() + ": ");
        Vector<SeguroComun> seg1 = seguro9.getSeguros();
        for (int i = 0; i < seg1.size(); i++){
            SeguroComun s = seg1.elementAt(i);
            System.out.println("   Seguro: " + s.getTipoPoliza());
            System.out.println("      Numero de poliza: " + s.getNroPoliza());
            System.out.println("      Costo de seguro: " + s.getCosto());
            for (Iterator it = s.getAtributos(); it.hasNext();){
                String aux = (String) it.next();
                System.out.println("      " + aux + ": " + s.getAtributo(aux));
            }
            System.out.println();
        }

        System.out.println("Seguro " + seguro10.getTipoPoliza() + ": ");
        Vector<SeguroComun> seg2 = seguro10.getSeguros();
        for (int i = 0; i < seg2.size(); i++){
            SeguroComun s = seg2.elementAt(i);
            System.out.println("   Seguro: " + s.getTipoPoliza());
            System.out.println("      Numero de poliza: " + s.getNroPoliza());
            System.out.println("      Costo de seguro: " + s.getCosto());
            for (Iterator it = s.getAtributos(); it.hasNext();){
                String aux = (String) it.next();
                System.out.println("      " + aux + ": " + s.getAtributo(aux));
            }
            System.out.println();
        }

        System.out.println("Seguro " + seguro11.getTipoPoliza() + ": ");
        Vector<SeguroComun> seg3 = seguro11.getSeguros();
        for (int i = 0; i < seg3.size(); i++){
            SeguroComun s = seg3.elementAt(i);
            System.out.println("   Seguro: " + s.getTipoPoliza());
            System.out.println("      Numero de poliza: " + s.getNroPoliza());
            System.out.println("      Costo de seguro: " + s.getCosto());
            for (Iterator it = s.getAtributos(); it.hasNext();){
                String aux = (String) it.next();
                System.out.println("      " + aux + ": " + s.getAtributo(aux));
            }
            System.out.println();
        }

        //Punto 4

        FilTipoDePoliza f1 = new FilTipoDePoliza("Automotor");
        System.out.println("Los seguros de tipo automotor son los siguientes: ");
        Vector<SeguroComun> filtrados = new Vector<>();
        filtrados.addAll(seguro9.filtrarSeguros(f1));
        filtrados.addAll(seguro10.filtrarSeguros(f1));
        filtrados.addAll(seguro11.filtrarSeguros(f1));
        for (int i = 0; i < filtrados.size(); i++){
            System.out.println("   Seguro N° " + filtrados.elementAt(i).getNroPoliza() + " - " + filtrados.elementAt(i).getAtributo("Tipo de auto"));
        }
        System.out.println();

        FAtributo f2 = new FAtributo("Puesto", "Delantero");
        System.out.println("Los seguros pertenecientes a delanteros son los siguientes: ");
        filtrados.clear();
        filtrados.addAll(seguro9.filtrarSeguros(f2));
        filtrados.addAll(seguro10.filtrarSeguros(f2));
        filtrados.addAll(seguro11.filtrarSeguros(f2));
        for (int i = 0; i < filtrados.size(); i++){
            System.out.println("   Seguro N° " + filtrados.elementAt(i).getNroPoliza() + " - " + filtrados.elementAt(i).getAtributo("Nombre y apellido"));
        }
        System.out.println();

        FPorMayor f3 = new FPorMayor(600);
        System.out.println("Los seguros cuyo costo es mayor a $" + f3.getUmbral() + " son los siguientes: ");
        filtrados.clear();
        filtrados.addAll(seguro9.filtrarSeguros(f3));
        filtrados.addAll(seguro10.filtrarSeguros(f3));
        filtrados.addAll(seguro11.filtrarSeguros(f3));
        for (int i = 0; i < filtrados.size(); i++){
            System.out.println("   Seguro N° " + filtrados.elementAt(i).getNroPoliza() + " - $" + filtrados.elementAt(i).getCosto());
        }
        System.out.println();

        FilTipoDePoliza f4 = new FilTipoDePoliza("Empleado");
        FPorMayor f5 = new FPorMayor(1100);
        FilAND f6 = new FilAND(f4, f5);
        FilAND f7 = new FilAND(f6, f2);
        System.out.println("Los seguros que cumplen los requisitos son los siguientes: ");
        filtrados.clear();
        filtrados.addAll(seguro9.filtrarSeguros(f7));
        filtrados.addAll(seguro10.filtrarSeguros(f7));
        filtrados.addAll(seguro11.filtrarSeguros(f7));
        for (int i = 0; i < filtrados.size(); i++){
            System.out.println("   Seguro N° " + filtrados.elementAt(i).getNroPoliza() + " - " + filtrados.elementAt(i).getAtributo("Nombre y apellido"));
        }
        System.out.println();
    }
}
