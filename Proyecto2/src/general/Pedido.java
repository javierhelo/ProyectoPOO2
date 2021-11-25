/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @authors Juleisy Porras y Javier Helo
 */
public class Pedido implements Serializable{
    private String fecha;
    private int codigo;
    private String persona;
    private TPedido tipo;
    private ArrayList<Producto> carrito = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(String fecha, int codigo, String persona, TPedido tipo) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.persona = persona;
        this.tipo = tipo;
    }
    
    public Pedido(String fecha, int codigo){
        this.fecha = fecha;
        this.codigo = codigo;
    }
    public void agregarProducto(Producto nuevo){
        carrito.add(nuevo);
    }
    
    /**
     * 
     * @param nuevo     Producto que se inserta
     * @param cantidad  Cantidad de veces que este se insertará en el pedido
     */
    public void agregarProducto(Producto nuevo, int cantidad){
        for (int i = 0; i < cantidad; i++){
            carrito.add(nuevo);
        }
    }
    
    /**
     * Función booleana que dice si un pedido está vacío
     * @return 
     */
    public boolean esPedidoValido(){
        return carrito.isEmpty();
    }
    
    public void borrarProductoPedido(String codigo){
        for (int i = 0; i < carrito.size(); i++){
            Producto actual = carrito.get(i);
            if (codigo.equalsIgnoreCase(actual.getCodigo())){
                carrito.remove(i);
                return;
            }
        }
        return;
    }
    
    public void borrarProductoPedido(String codigo, int cantidad){
        for (int i = 0; i < cantidad; i++){
            borrarProductoPedido(codigo);
        } 
    }
    
     /**
     * 
     * @param platillo
     * @return retorna un String que corresponde
     * al tipo de platillo enviado por parámetro
     */
    public String getPlatilloString(TPlatillo platillo){
        if (platillo == TPlatillo.BEB){
            return "Bebida";
        }
        if (platillo == TPlatillo.ENT){
            return "Entrada";
        }
        if (platillo == TPlatillo.PRN){
            return "Plato fuerte";
        }
        return "Postre";
    }
    
    public double precioPedido(){
        double total = 0;
        for (Producto actual : carrito){
            total += actual.getPrecio();
        }
        return total;
    }
   
    public String getFecha() {
        return fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getPersona() {
        return persona;
    }

    public TPedido getTipo() {
        return tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public void setTipo(TPedido tipo) {
        this.tipo = tipo;
    }

    public void setCarrito(ArrayList<Producto> carrito) {
        this.carrito = carrito;
    }

    public ArrayList<Producto> getCarrito() {
        return carrito;
    }

    @Override
    public String toString() {
        return "Pedido:" + "Código: " + codigo + "Fecha: " + fecha + "- Persona: " + persona + "- Tipo: " + tipo + '\n';
    }
}
