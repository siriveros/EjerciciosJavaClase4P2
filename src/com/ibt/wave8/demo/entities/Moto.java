package com.ibt.wave8.demo.entities;

public class Moto extends Vehiculo{

    public static final int DEFAULT_PESO_MOTO = 300;
    public static final int DEFAULT_CANTIDAD_RUEDAS = 2;

    public Moto() {
    }

    public Moto(int velocidad, int aceleracion, int anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, DEFAULT_PESO_MOTO, DEFAULT_CANTIDAD_RUEDAS);
    }
}
