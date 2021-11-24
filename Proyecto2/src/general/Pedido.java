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
    private ArrayList<Producto> productos = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(String fecha, int codigo, String persona, TPedido tipo) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.persona = persona;
        this.tipo = tipo;
    }
    
    public void agregarProducto(Producto nuevo){
        productos.add(nuevo);
    }
    
    public void borrarProductoPedido(String codigo){
        for (int i = 0; i < productos.size(); i++){
            Producto actual = productos.get(i);
            if (codigo.equalsIgnoreCase(actual.getCodigo())){
                productos.remove(i);
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
    
    
    
//    public double calcularPrecio(){
//        
//    }

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

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    
}
