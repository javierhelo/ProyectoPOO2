package AppServidora.control;

import general.IConstantes;
import general.Producto;
import general.TPlatillo;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class AdmProductos {
    
    private ArrayList<Producto> listaProductos = new ArrayList();
    private ArrayList<String[]> datosProducto = new ArrayList();
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

    public ArrayList<String[]> getDatosProducto() {
        return datosProducto;
    }

    public void setDatosProducto(ArrayList<String[]> datosProducto) {
        this.datosProducto = datosProducto;
    }
    
    public Producto getProductosPorPos(int pos){
        return listaProductos.get(pos);
    }
    /**
     * 
     * @param tipo
     * @return retorna un objeto TPlatillo
     * asociado al valor del String del objeto de entrada
     */
    public TPlatillo getTipo(Object tipo){
        tipo = String.valueOf(tipo);
        if (tipo.equals("ENT")){
            return TPlatillo.ENT;
        }
        else if (tipo.equals("BEB")){
            return TPlatillo.BEB;
        }
        else if (tipo.equals("PRN")){
            return TPlatillo.PRN;
        }
        else{
            return TPlatillo.PTR;
        }
    }
    
    /**
     * 
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param tamPorcion
     * @param piezas
     * @param calPorcion
     * @param calPieza
     * @param precio
     * @param tipo
     * @return retorna un valor booleano indicando
     * si el producto según los datos de entrada logró ser añadido al catálogo
     */
    public boolean agregarProductoAdm(String codigo, String nombre, String descripcion, String tamPorcion, String piezas, String calPorcion,
            String calPieza, String precio, Object tipo){
        
        int tamPorcionP = Integer.parseInt(tamPorcion);
        int piezasP = Integer.parseInt(piezas);
        double calPorcionP = Double.parseDouble(calPorcion);
        double calPiezaP = Double.parseDouble(calPieza);
        double precioP = Double.parseDouble(precio);
        TPlatillo tipoP = getTipo(tipo);
        
        agregarProducto(codigo, nombre, descripcion, tamPorcionP, piezasP, calPorcionP, calPiezaP, precioP, tipoP);
        
        return true;
    }
    
    /**
     * Función que agrega un producto al archivo binario y a la lista de Productos
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param tamPorcion
     * @param piezas
     * @param calPorcion
     * @param calPieza
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
     * @param codigo 
     * @return retorna un valor booleano indicando
     * si el producto según el codigo de entrada logró ser eliminado del catálogo 
     */
    public boolean eliminarProducto(String codigo){
        for(Producto actual : listaProductos){
            if(actual.getCodigo().equals(codigo)){
                listaProductos.remove(actual);
                return true;
            }
        }
        return false;
    }
    
    /**
     * @param codigo
     * @return retorna un ArrayList con arreglos de los datos de 
     * un producto de la lista de productos, estos datos se despliegan en
     * la tabla de ver producto y en el catálogo para eliminar producto.
     */
    public ArrayList<String[]> datosCarrito(String codigo){
        String[] datos = new String[9];
        for(Producto actual : listaProductos){
            if(actual.getCodigo().equals(codigo)){
                datos[0] = String.valueOf(actual.getCodigo());
                datos[1] = String.valueOf(actual.getNombre());
                datos[2] = String.valueOf(actual.getDescripcion());
                datos[3] = String.valueOf(actual.getTamPorcion());
                datos[4] = String.valueOf(actual.getPiezas());
                datos[5] = String.valueOf(actual.getCalPorcion());
                datos[6] = String.valueOf(actual.getCalPieza());
                datos[7] = String.valueOf(actual.getPrecio());
                datos[8] = getPlatilloString(actual.getTipo());
            }
            
        }
        datosProducto.add(datos);
        return datosProducto;
    }
    
    /**
     * Función que verifica que un producto esté en el catálogo en base a su código
     * @param codigo
     * @return 
     */
    public boolean contains(String codigo){
        for (Producto actual : listaProductos){
            if (actual.getCodigo().equals(codigo)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Función que devuelve un objeto Producto del catálogo.
     * @param codigo
     * @return 
     */
    public Producto obtenerProducto(String codigo){
        for (Producto actual : listaProductos){
            if (actual.getCodigo().equalsIgnoreCase(codigo)){
                return actual;
            }
        }
        return null;
    }
    
    /**
     * @return retorna un ArrayList con arreglos de los datos de 
     * un producto de la lista de productos, estos datos se despliegan en
     * la tabla de ver producto y en el catálogo para eliminar producto.
     */
    public ArrayList<String[]> datosVerProducto(){
        ArrayList<String[]> datosProducto = new ArrayList();
        for (Producto actual : listaProductos ){
            String[] datos = new String[9];
            datos[0] = String.valueOf(actual.getCodigo());
            datos[1] = String.valueOf(actual.getNombre());
            datos[2] = String.valueOf(actual.getDescripcion());
            datos[3] = String.valueOf(actual.getTamPorcion());
            datos[4] = String.valueOf(actual.getPiezas());
            datos[5] = String.valueOf(actual.getCalPorcion());
            datos[6] = String.valueOf(actual.getCalPieza());
            datos[7] = String.valueOf(actual.getPrecio());
            datos[8] = getPlatilloString(actual.getTipo());;
            datosProducto.add(datos);
        }
        return datosProducto;
    }
    
     /**
     * @return retorna un ArrayList con arreglos de los datos de 
     * cada producto de la lista de productos, estos datos se despliegan en
     * la tabla del catálogo de productos.
     */
    public ArrayList<String[]> datosMenu(){
        ArrayList<String[]> datosProducto = new ArrayList();
        for (Producto actual : listaProductos ){
            String[] datos = new String[4];
            datos[0] = String.valueOf(actual.getCodigo());
            datos[1] = String.valueOf(actual.getNombre());
            datos[2] = String.valueOf(actual.getCalPorcion());
            datos[3] = "Ver producto";
            datosProducto.add(datos);
        }
        return datosProducto;
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
