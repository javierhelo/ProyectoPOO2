package AppServidora.control;

import general.Peticion;

public class Controlador {
    private AdmUsuarios admUsr;
    private AdmProductos admPro;
    private AdmPedidos admPed;

    public Controlador() {
        admPro = new AdmProductos();
        admUsr = new AdmUsuarios();
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
