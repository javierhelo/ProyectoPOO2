/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppServidora.control;

import general.IConstantes;

/**
 *
 * @author Juley
 */
public class AdmUsuarios {
    
    public AdmUsuarios() {
    }
    
    public boolean validarAdm(String login, String pwd){
        return login.equals(IConstantes.USERADM) && pwd.equals(IConstantes.PWADM);
    }
}
