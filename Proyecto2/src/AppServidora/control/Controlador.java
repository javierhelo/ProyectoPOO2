package AppServidora.control;

import general.Peticion;

public class Controlador {
    private AdmUsuarios admUsr;
    private AdmProductos admPro;
    private AdmPedidos admPed;
    private int contador = 0;

    public Controlador() {
        admPro = new AdmProductos();
        admUsr = new AdmUsuarios();
        admPed = new AdmPedidos();
    }

    public AdmUsuarios getAdmUsr() {
        return admUsr;
    }

    public void setAdmUsr(AdmUsuarios admUsr) {
        this.admUsr = admUsr;
    }

    public AdmProductos getAdmPro() {
        return admPro;
    }

    public void setAdmPro(AdmProductos admPro) {
        this.admPro = admPro;
    }

    public AdmPedidos getAdmPed() {
        return admPed;
    }

    public void setAdmPed(AdmPedidos admPed) {
        this.admPed = admPed;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
    
    public double precio(int codigo){
        return admPed.calcularPrecio(codigo);
    }
    
    
    
    
    /**
     * Función que busca un producto en el catálogo para luego poder agregarlo al carrito
     * @param codigo
     * @return 
     */
    public Object obtenerProducto(String codigo){
        return admPro.obtenerProducto(codigo);
    }
 
    public Peticion procesarPeticion(Peticion peticionRecibida) {
        int n = 0;
        switch (peticionRecibida.getAccion()) {
            case INGRESAR:
                String credenciales = (String) peticionRecibida.getDatosEntrada();
                String[] partes = credenciales.split("-");
                boolean admOK = admUsr.validarAdm(partes[0], partes[1]);
                peticionRecibida.setDatosSalida(admOK);
                break;
            case VER_PRODUCTO:
                break;
            case INGRESAR_CLIENTE:
                boolean clienteOK = true;
                admPed.generarPedido(n);
                n++;
                contador++;
                peticionRecibida.setDatosSalida(clienteOK);
                break;
            case AGREGAR_CARRITO:
                String codigoFrm = (String) peticionRecibida.getDatosEntrada();
                int codigo = n;
                boolean productoOK;
                if (admPro.contains(codigoFrm)) {
                    productoOK = admPed.agregarProductoAUnPedido(codigo, admPro.obtenerProducto(codigoFrm));
                    peticionRecibida.setDatosSalida(productoOK);
                } else {
                    productoOK = false;
                    peticionRecibida.setDatosSalida(productoOK);
                }
                break;
            case VER_PEDIDOS:
                peticionRecibida.setDatosSalida(admPed.toString()+ "\n\n");
                break;
            case FINALIZAR_EXPRESS:
                peticionRecibida.setDatosSalida(true);
                //numeros de celular válidos
                break;
            case FINALIZAR_RECOGER:
                peticionRecibida.setDatosSalida(true);
                break;
            case FINALIZAR_PEDIDO:
                peticionRecibida.setDatosSalida(true);
                break;
        }
        return peticionRecibida;
    }
}
