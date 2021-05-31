package com.ibt.wave8.demo;

import com.ibt.wave8.demo.entities.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Vehiculo> vehiculosIniciales = new ArrayList<>();
        vehiculosIniciales.add(new Auto(80, 20, 30, "BNK890"));
        vehiculosIniciales.add(new Moto(100, 10, 10, "KNH423"));
        vehiculosIniciales.add(new Auto(75, 50, 20, "OPY657"));
        vehiculosIniciales.add(new Moto(90, 40, 20, "YUT890"));
        vehiculosIniciales.add(new Auto(50, 50, 50, "NBR342"));


        Carrera carrera = new Carrera(2000, 10000, "Las 80 Dunas de Bogota",
                6, vehiculosIniciales,
                new SocorristaAuto(100, 100, 50, "AUX001"),
                new SocorristaMoto(120, 120, 25, "AUX002"));

        System.out.println(carrera.getListaVehiculos());

        carrera.darDeAltaAuto(60,30,30,"HJK667");

        System.out.println(carrera.getListaVehiculos());
        carrera.eliminarVehiculo(new Auto(75, 50, 20, "OPY657"));

        System.out.println(carrera.getListaVehiculos());
        carrera.darDeAltaMoto(60,30,30,"IJK812");

        System.out.println(carrera.getListaVehiculos());

        carrera.socorrerAuto("BNK890");
        carrera.socorrerMoto("IJK812");

        System.out.println(carrera.definirGanador());


    }
}
