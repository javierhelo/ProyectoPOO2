/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.Serializable;

/**
 *
 * @authors Juleisy Porras y Javier Helo
 */
public class Peticion implements Serializable{
    private TAccion accion;
    private Object datosEntrada;
    private Object datosSalida;

    public Peticion() {
    }
    

    public Peticion(TAccion accion, Object datosEntrada) {
        this.accion = accion;
        this.datosEntrada = datosEntrada;
    }

    public TAccion getAccion() {
        return accion;
    }

    public void setAccion(TAccion accion) {
        this.accion = accion;
    }

    public Object getDatosEntrada() {
        return datosEntrada;
    }

    public void setDatosEntrada(Object datosEntrada) {
        this.datosEntrada = datosEntrada;
    }

    public Object getDatosSalida() {
        return datosSalida;
    }

    public void setDatosSalida(Object datosSalida) {
        this.datosSalida = datosSalida;
    }

    @Override
    public String toString() {
        return "Peticion: " + "Accion: " + accion + "- Datos de entrada: " 
                + datosEntrada + "- Datos de salida: " + datosSalida;
    }
}