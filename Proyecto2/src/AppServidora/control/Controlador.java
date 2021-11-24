package AppServidora.control;

import general.Peticion;

public class Controlador {
    private AdmUsuarios admUsr = new AdmUsuarios();
    private AdmProductos admPro = new AdmProductos();
    private AdmPedidos admPed = new AdmPedidos();

    public Controlador() {
    }
    
    public Peticion procesarPeticion(Peticion peticionRecibida) {
        switch (peticionRecibida.getAccion()){
            case INGRESAR: 
                 String credenciales = (String) peticionRecibida.getDatosEntrada();
                 String [] partes  = credenciales.split("-"); 
                 boolean admOK = admUsr.validarAdm(partes[0], partes[1]);
                 peticionRecibida.setDatosSalida(admOK);
                break;
            case VER_PRODUCTOS:
//                admPro.crearMenu();
                peticionRecibida.setDatosSalida(admPro.toString()+ "\n\n");
                break;
        }
        return peticionRecibida;
    }
}
