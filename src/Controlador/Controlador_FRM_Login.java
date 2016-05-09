/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesse Fabian
 */
public class Controlador_FRM_Login implements ActionListener {


    FRM_Login login;
    FRM_MantenimientoUsuarios usuarios;
    ConexionBD conexion;

    
    public Controlador_FRM_Login(FRM_Login login)
    {
        this.login=login;
        usuarios=new FRM_MantenimientoUsuarios();
        this.conexion=conexion;
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Entrar"))
        {
           if(conexion.consultarUsuarios(login.devolverInformacion()))
           {
               mensaje("Bienvenido "+login.devolverNombre());
               this.login.setVisible(false);
           }
           else
           {
               this.login.setVisible(true);
               mensaje("Acceso denegado, por favor revise sus datos e intente nuevamente o registrese");
           }
        }
        if(e.getActionCommand().equals("Registrarse"))
        {
            this.usuarios.setVisible(true);
        }
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
    }
    
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
}
