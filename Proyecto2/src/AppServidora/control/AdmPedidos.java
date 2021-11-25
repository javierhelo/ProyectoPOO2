/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppServidora.control;

import general.Pedido;
import general.Producto;
import general.TPedido;
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
     * Función que crea un pedido nuevo con la fecha automáticamente
     * utilizando Instant.now() 
     * @param codigo
     */
    public void generarPedido(int codigo){
        Pedido nuevo = new Pedido(Date.from(Instant.now()).toString(), codigo);
        agregarPedido(nuevo);
    }
    
//    public void crearPedidos(){
//        Pedido nuevo1 = new Pedido("12-12-12", 12, "Javier", TPedido.EXPRESS);
//        Pedido nuevo2 = new Pedido("13-11-12", 13, "Juleisy", TPedido.RECOGER);
//        
//        listaPedidos.add(nuevo1);
//        listaPedidos.add(nuevo2);
//    }
    
    public double calcularPrecio(int codigo){
        double precio = 0;
        for (Pedido actual : listaPedidos){
            if (actual.getCodigo() == codigo){
                precio = actual.precioPedido();
            }
        }
        return precio;
    }
    
    
    
    /**
     * Función booleana que dice si un producto se pudo agregar a un determinado pedido
     * @param codigo : Codigo del pedido en el cual se insertará el producto
     * @param porAgregar : Producto que se agrega a dicho pedido
     * @param cantidad : Cantidad de veces indicada para agregar dicho producto
     * @return 
     */
    public boolean agregarProductoAUnPedido(int codigo, Producto porAgregar){
        for (int i = 0; i < listaPedidos.size(); i++){
            Pedido actual = listaPedidos.get(i);
            if (actual.getCodigo() == codigo){
                actual.agregarProducto(porAgregar);
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

    @Override
    public String toString() {
        return "Pedidos:" + '\n' + listaPedidos + '\n';
    }
}
