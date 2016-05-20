/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoUsuarios;
import Modelo.ConexionBD;
import Modelo.Cursos;
import Modelo.MetodosUsuarios;
import Modelo.Metodos_XML;
import Modelo.Usuario;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesse Fabian
 */
public class Controlador_FRM_Login implements ActionListener {


    FRM_Login login;
    FRM_MantenimientoUsuarios usuarios;
    ConexionBD conexion;
    Metodos_XML metodos;
    FRM_MenuPrincipal menu;
    ArchivoUsuarios archivo;
    MetodosUsuarios metodosUsuarios;
    int fuente=0;
    public Controlador_FRM_Login(FRM_Login login,FRM_MenuPrincipal menu)
    {
        this.login=login;
        usuarios=new FRM_MantenimientoUsuarios(menu);
        this.menu=menu;
        this.conexion=conexion;
        this.metodos=metodos;
        this.archivo=archivo;
        metodosUsuarios=new MetodosUsuarios();
//        metodosUsuarios.setArray(archivo.devolverInformacionDeUsuario());
    }
    
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
     public void crearArchivo()
    {
      ArrayList <Usuario> array=metodosUsuarios.getArray();
     archivo.cargarArchivoUsuarios();
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivo.ingresarInformacionUsuarios(array.get(conta));
         archivo.devolverInformacionDeUsuario();
     }   
     
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Entrar"))
        {
           if(fuente==1)
           {
               if(metodosUsuarios.consultarLoginUsuario(login.devolverNombre(),login.devolverContraseña()))
           {
               login.mensaje("Bienvenido "+login.devolverNombre());
               this.login.setVisible(false);
               this.menu.setVisible(true);
               //se subió
           }
           else
           {
               this.login.setVisible(true);
               login.mensaje("Acceso denegado, por favor revise sus datos e intente nuevamente o registrese");
           }
           }
           if(fuente==2)
           {
            if(conexion.consultarUsuarios(login.devolverInformacion()))
           {
               login.mensaje("Bienvenido "+login.devolverNombre());
               this.login.setVisible(false);
               this.menu.setVisible(true);
               //se subió
           }
           else
           {
               this.login.setVisible(true);
               login.mensaje("Acceso denegado, por favor revise sus datos e intente nuevamente o registrese");
           }
           }
           if(fuente==3)
           {
            if(metodos.consultarInformacionDeUsuarios(login.devolverNombre(),login.devolverContraseña()))
           {
               login.mensaje("Bienvenido "+login.devolverNombre());
               this.login.setVisible(false);
               this.menu.setVisible(true);
               //se subió
           }
           else
           {
               this.login.setVisible(true);
               login.mensaje("Acceso denegado, por favor revise sus datos e intente nuevamente o registrese");
           }   
           }
        }
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);
        }
    }
    
}
