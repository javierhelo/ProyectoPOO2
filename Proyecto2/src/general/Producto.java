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
public class Producto implements Serializable {
    private String codigo;
    private String nombre;
    private String descripcion;
    private int tamPorcion;
    private int piezas;
    private double calPorcion;
    private double calPieza;
    private double precio;
    private TPlatillo tipo;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String descripcion, int tamPorcion, int piezas, double calPorcion, double calPieza, double precio, TPlatillo tipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamPorcion = tamPorcion;
        this.piezas = piezas;
        this.calPorcion = calPorcion;
        this.calPieza = calPieza;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getTamPorcion() {
        return tamPorcion;
    }

    public void setTamPorcion(int tamPorcion) {
        this.tamPorcion = tamPorcion;
    }

    public int getPiezas() {
        return piezas;
    }

    public void setPiezas(int piezas) {
        this.piezas = piezas;
    }

    public double getCalPorcion() {
        return calPorcion;
    }

    public void setCalPorcion(double calPorcion) {
        this.calPorcion = calPorcion;
    }

    public double getCalPieza() {
        return calPieza;
    }

    public void setCalPieza(double calPieza) {
        this.calPieza = calPieza;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public TPlatillo getTipo() {
        return tipo;
    }

    public void setTipo(TPlatillo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto:" + "  Codigo: " + codigo + "- Nombre: " + nombre + 
                "- Descripcion: " + descripcion + "- Tamaño de la porcion: " + tamPorcion + 
                "- Piezas por porcion: " + piezas + "- Calorias en 1 porcion: " + calPorcion + 
                "- Calorias por pieza: " + calPieza + "- Precio: " + precio + 
                "- Tipo de platillo: " + tipo;
    }
}
