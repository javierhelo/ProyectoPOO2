package AppServidora.control;

import general.IConstantes;
import general.Producto;
import general.TPlatillo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class AdmProductos {
    
    private ArrayList<Producto> listaProductos = new ArrayList();
    private Producto lista[] = {
            new Producto("PRN-001", "Albóndigas", "Esferas de carne molida en salsa roja.", 400, 14, 788, 57, 10000.00, TPlatillo.PRN), //Calorías confirmadas por google (culinariamente comprobados)
            new Producto("PRN-002", "Arroz frito", "Arroz hecho al sartén con una combinación de hierbas y aceite de trufas .", 
                    500, 1, 788, 57, 6000.00, TPlatillo.PRN),
            new Producto("PRN-003", "Burrito", "Pollo, frijoles y queso envuelto en tortilla de trigo.", 550, 1, 326, 326, 6000.00, TPlatillo.PRN),
            
            new Producto("BEB-010", "Mojito", "cóctel cubano, que se prepara con ron, lima, azúcar, hielo y hierbabuena o menta.", 
                    600, 1, 270, 270, 2000.00, TPlatillo.BEB),
            new Producto("BEB-020", "Sprite", "Bebida gaseosa popular compuesta de agua carbonatada, azucar y otros químicos (no es bueno para tu salud).", 
                    600, 1, 246, 41, 1500.00, TPlatillo.BEB),
            
            new Producto("PTR-100", "Cheesecake", "Mezcla de queso fresco y suave, huevos y azúcar", 
                    375, 1, 1203, 1203, 4000.00, TPlatillo.PTR),
            new Producto("PTR-200", "Pie de Limón", "Nuestro cremoso pie de Limón", 
                    400, 2, 1000, 500, 5500.5, TPlatillo.PTR),
            
            new Producto("ENT-911", "Papas asadas", "Papas enteras asadas con queso y trocitos de tocineta encima.", 
                    544, 4, 812, 203, 7500.00, TPlatillo.ENT),
            
        };

    public AdmProductos() {
        listaProductos.addAll(Arrays.asList(lista));
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public Producto[] getLista() {
        return lista;
    }

    public void setLista(Producto[] lista) {
        this.lista = lista;
    }
    
    /**
     * Función que agrega un Producto a la lista de Productos
     * @param nuevo 
     */
    public void agregarProducto(Producto nuevo){
        listaProductos.add(nuevo);
    }
    
    /**
     * Función que agrega un producto al archivo binario y a la lista de Productos
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param tamPorcion
     * @param piezas
     * @param calPorcion
     * @param precio
     * @param tipo 
     */
    public void agregarProducto(String codigo, String nombre, String descripcion, int tamPorcion, int piezas, double calPorcion, double calPieza, double precio, TPlatillo tipo){
        Producto porAgregar[] = {
            new Producto(codigo, nombre, descripcion, tamPorcion, piezas, calPorcion, calPieza, precio, tipo),
        };
        int escribirMenu = escribirMenu("src\\menu.dat", porAgregar);
        listaProductos.add(new Producto(codigo, nombre, descripcion, tamPorcion, piezas, calPorcion, calPieza, precio, tipo));
    }
    
    /**
     * Función que escribe los elementos de una lista de productos en un archivo binario.
     * @param nombreArchivo
     * @param lista
     * @return 
     */
    public int escribirMenu(String nombreArchivo, Producto [] lista){
        FileOutputStream archivoEscritura = null;
        ObjectOutputStream manejadorEscritura = null;
        try{
            //apertura del archivo
            manejadorEscritura = new ObjectOutputStream(new FileOutputStream (nombreArchivo));
            
            //procesamiento
            for (int i = 0; i < lista.length; i++){
                manejadorEscritura.writeObject(lista[i]);
            }
            return IConstantes.EXITO;
            
        }catch (FileNotFoundException ex){
            System.out.println("No se pudo crear el archivo " + nombreArchivo);
            return IConstantes.ERROR_ARCHIVO;
        }catch (IOException ex){
            System.out.println("Se presentaron problemas para escribir el archivo " + nombreArchivo);
            return IConstantes.ERROR_ARCHIVO;
        }
        finally{
            try{
                if (manejadorEscritura != null){
                    manejadorEscritura.flush();
                    manejadorEscritura.close();
                }
            }catch (IOException ex) {
                return IConstantes.ERROR_ARCHIVO;
            }
        }
    }

    @Override
    public String toString() {
        return "Lista de Productos: " + listaProductos + '\n';
    }
}
