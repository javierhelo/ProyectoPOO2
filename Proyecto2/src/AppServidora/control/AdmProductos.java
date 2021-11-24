package AppServidora.control;

import general.Producto;
import general.TPlatillo;
import java.util.ArrayList;

public class AdmProductos {
    
    private ArrayList<Producto> listaProductos = new ArrayList();
    

    public AdmProductos() {
        Producto lista[] = {
            new Producto("PRN-001", "Albóndigas", "Esferas de carne molida en salsa roja.", 400, 14, 788, 57, 10000.00, TPlatillo.PRN), //Calorías confirmadas por google (culinariamente comprobados)
            new Producto("PRN-002", "Arroz frito", "Arroz hecho al sartén con una combinación de hierbas y aceite de trufas .", 
                    500, 1, 788, 57, 6000.00, TPlatillo.PRN),
            new Producto("PRN-003", "Burrito", "Pollo, frijoles y queso envuelto en tortilla de trigo.", 550, 1, 326, 326, 6000.00, TPlatillo.PRN),
            
            new Producto("BEB-010", "Mojito", "cóctel cubano, que se prepara con ron, lima, azúcar, hielo y hierbabuena o menta.", 
                    600, 1, 270, 270, 2000.00, TPlatillo.BEB),
            new Producto("BEB-020", "Sprite", "Bebida gaseosa popular compuesta de agua carbonatada, azucar y otros químicos (no es bueno para tu salud).", 
                    600, 1, 246, 41, 1500.00, TPlatillo.BEB),
            
            new Producto("PTR-100", "Cheesecake", "mezcla de queso fresco y suave, huevos y azúcar", 
                    375, 1, 1203, 1203, 4000.00, TPlatillo.PTR),
            
            new Producto("ENT-911", "Papas asadas", "Papas enteras asadas con queso y trocitos de tocineta encima.", 
                    544, 4, 812, 203, 7500.00, TPlatillo.ENT),
        };
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
