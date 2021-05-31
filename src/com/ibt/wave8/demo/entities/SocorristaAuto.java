package com.ibt.wave8.demo.entities;

public class SocorristaAuto extends Auto implements ISocorrista<Auto>{

    public SocorristaAuto() {
        super();
    }

    public SocorristaAuto(int velocidad, int aceleracion, int anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
    }

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto " + vehiculo.getPatente());
    }
}
