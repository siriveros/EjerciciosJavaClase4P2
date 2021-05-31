package com.ibt.wave8.demo.entities;

public class SocorristaMoto extends Moto implements ISocorrista<Moto>{

    public SocorristaMoto() {
        super();
    }

    public SocorristaMoto(int velocidad, int aceleracion, int anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente);
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto " + vehiculo.getPatente() );
    }
}
