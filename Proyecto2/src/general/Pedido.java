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
public class Pedido implements Serializable{
    private String fecha;
    private int codigo;
    private String persona;
    private TPedido tipo;

    public Pedido() {
    }

    public Pedido(String fecha, int codigo, String persona, TPedido tipo) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.persona = persona;
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public TPedido getTipo() {
        return tipo;
    }

    public void setTipo(TPedido tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Pedido: " + "Fecha: " + fecha + "- Codigo: " + codigo 
                + "- Persona que realizo el pedido: " + persona 
                + "- Tipo de pedido: " + tipo;
    }
}
