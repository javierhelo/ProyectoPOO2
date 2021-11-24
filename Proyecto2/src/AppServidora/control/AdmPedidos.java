/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppServidora.control;

import general.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Juley
 */
public class AdmPedidos {
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();

    public AdmPedidos() {
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
