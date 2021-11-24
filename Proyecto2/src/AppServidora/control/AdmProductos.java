package AppServidora.control;

import general.Producto;
import java.util.ArrayList;

public class AdmProductos {
    
    private ArrayList<Producto> listaProductos = new ArrayList();

    public AdmProductos() {
        
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void escribirMenu(){
        
    }

    @Override
    public String toString() {
        return "Lista de Productos: " + listaProductos + '\n';
    }
}
