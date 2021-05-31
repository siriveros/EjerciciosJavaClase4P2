package com.ibt.wave8.demo.entities;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private int distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> listaVehiculos;

    private ISocorrista<Auto> socorristaAuto;
    private ISocorrista<Moto> socorristaMoto;

    public Carrera() {
        this.distancia = 0;
        this.premioEnDolares = 0;
        this.nombre = "";
        this.cantidadVehiculosPermitidos = 0;
        this.listaVehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Carrera(int distancia, int premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> listaVehiculos, ISocorrista socorristaAuto, ISocorrista socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaVehiculos = listaVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(int premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadVehiculosPermitidos() {
        return cantidadVehiculosPermitidos;
    }

    public void setCantidadVehiculosPermitidos(int cantidadVehiculosPermitidos) {
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public ISocorrista<Auto> getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(ISocorrista<Auto> socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public ISocorrista<Moto> getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(ISocorrista<Moto> socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(int velocidad, int aceleracion, int anguloGiro, String patente) throws Exception {
        if (this.listaVehiculos.size() < this.cantidadVehiculosPermitidos) {
            this.listaVehiculos.add(new Auto(velocidad, aceleracion, anguloGiro, patente));
        } else {
            throw new Exception("La carrera esta llena");
        }

    }

    public void darDeAltaMoto(int velocidad, int aceleracion, int anguloGiro, String patente) throws Exception {
        if (this.listaVehiculos.size() < this.cantidadVehiculosPermitidos) {
            this.listaVehiculos.add(new Moto(velocidad, aceleracion, anguloGiro, patente));
        } else {
            throw new Exception("La carrera esta llena");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.eliminarVehiculo(vehiculo.getPatente());
    }

    public void eliminarVehiculo(String patente) {
        for (int i = 0; i < this.listaVehiculos.size(); i++) {
            if (patente.equals(this.listaVehiculos.get(i).getPatente())) {
                this.listaVehiculos.remove(i);
                break;
            }
        }
    }

    public Vehiculo definirGanador() {
        Vehiculo vehiculoGanador = null;
        double velocidadMaxima = 0;
        for (Vehiculo vehiculo : listaVehiculos) {
            double velocidadMaximaVehiculoActual = this.calcularVelocidadMaxima(vehiculo);
            if(velocidadMaximaVehiculoActual > velocidadMaxima){
                velocidadMaxima = velocidadMaximaVehiculoActual;
                vehiculoGanador = vehiculo;
            }
        }
        return vehiculoGanador;
    }

    private double calcularVelocidadMaxima(Vehiculo vehiculo) {
        return ((double)vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) /
                (vehiculo.getAnguloGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public void socorrerAuto(String patente) throws Exception {
        boolean vehiculoEncontrado = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo instanceof Auto) {
                if (patente.equals(vehiculo.getPatente())) {
                    this.socorristaAuto.socorrer((Auto) vehiculo);
                    vehiculoEncontrado = true;
                }
            }
        }
        if (!vehiculoEncontrado){
            throw new Exception("No se encontro el vehiculo");
        }
    }

    public void socorrerMoto(String patente) throws Exception {
        boolean vehiculoEncontrado = false;
        for (Vehiculo vehiculo : listaVehiculos) {
            if(vehiculo instanceof Moto){
                if(patente.equals(vehiculo.getPatente())){
                    this.socorristaMoto.socorrer((Moto)vehiculo);
                    vehiculoEncontrado = true;
                }
            }
        }
        if (!vehiculoEncontrado){
            throw new Exception("No se encontro el vehiculo");
        }
    }
}