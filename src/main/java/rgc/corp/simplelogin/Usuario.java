/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rgc.corp.simplelogin;

import java.sql.Date;

/**
 *
 * @author RGC
 */
public class Usuario {
    
    private String usuario;
    private String clave;
    private Date inicioSession;

    public Usuario(String usuario,String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.inicioSession = new Date(new java.util.Date().getTime());
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getInicioSession() {
        return inicioSession;
    }

    public void setInicioSession(Date inicioSession) {
        this.inicioSession = inicioSession;
    }
    
    
    

}
