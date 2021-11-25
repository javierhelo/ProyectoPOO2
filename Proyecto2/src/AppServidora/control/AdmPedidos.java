/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppServidora.control;

import general.Pedido;
import general.Producto;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Juley
 */
public class AdmPedidos {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public AdmPedidos() {
    }
    
    /**
     * Función que crea un pedido nuevo y lo devuelve generando la fecha automáticamente
     * utilizando Instant.now()
     * @return 
     */
    public void generarPedido(){
        Pedido nuevo = new Pedido(Date.from(Instant.now()).toString());
        agregarPedido(nuevo);
    }
    
    /**
     * Función booleana que dice si un producto se pudo agregar a un determinado pedido
     * @param codigo : Codigo del pedido en el cual se insertará el producto
     * @param porAgregar : Producto que se agrega a dicho pedido
     * @param cantidad : Cantidad de veces indicada para agregar dicho producto
     * @return 
     */
    public boolean agregarProductoAUnPedido(int codigo, Producto porAgregar, int cantidad){
        for (int i = 0; i < listaPedidos.size(); i++){
            Pedido actual = listaPedidos.get(i);
            if (actual.getCodigo() == codigo){
                actual.agregarProducto(porAgregar, cantidad);
                return true;
            }
        }
        return false;
    }
    
    public void agregarPedido(Pedido nuevo){
        listaPedidos.add(nuevo);
    }
    
    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(ArrayList<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    
}
