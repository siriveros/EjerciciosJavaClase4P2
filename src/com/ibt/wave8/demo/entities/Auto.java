package com.ibt.wave8.demo.entities;

public class Auto extends Vehiculo{

    public static final int DEFAULT_PESO_AUTO = 1000;
    public static final int DEFAULT_CANTIDAD_RUEDAS = 4;

    public Auto() {
    }

    public Auto(int velocidad, int aceleracion, int anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, DEFAULT_PESO_AUTO, DEFAULT_CANTIDAD_RUEDAS);
    }
}
