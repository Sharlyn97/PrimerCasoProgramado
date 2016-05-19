
package Controlador;

import Modelo.ArchivoUsuarios;
import Modelo.ConexionBD;
import Modelo.Estudiante;
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

// afopsdmgfdmgodhbdkflokdmgotrfsfoiffmdvpodfbodfzmc

public class Controlador_FRM_MantenimientoUsuarios implements ActionListener{
    
FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
FRM_Login login;
ConexionBD conexion;
Metodos_XML metodos;
MetodosUsuarios metodosUsuarios;
ArchivoUsuarios archivo;
int fuente=0;

    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frm_MantenimientoUsuarios) 
    {
        this.frm_MantenimientoUsuarios=frm_MantenimientoUsuarios;
        this.conexion=conexion;
        this.metodos=metodos;
        login.login.archivo=this.archivo;
        metodosUsuarios=new MetodosUsuarios();
        metodosUsuarios.setArray(archivo.devolverInformacionDeUsuario());
        
    }
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
     public void crearArchivo()
    {
      ArrayList <Usuario> array=metodosUsuarios.getArray();
     archivo.crearArchivoUsuarios();
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivo.ingresarInformacionUsuarios(array.get(conta));
         archivo.devolverInformacionDeUsuario();
     }   
     
    }
    
    public void actionPerformed(ActionEvent e) 
    {
            if(e.getActionCommand().equals("Agregar"))
            {   
           if(fuente==1)
           {
              metodosUsuarios.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
              frm_MantenimientoUsuarios.resetearInterfaz();
              mensaje("Se agregó correctamente");
            
           }
           if(fuente==2)
           {
           conexion.registrarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto(),frm_MantenimientoUsuarios.devolverNombreUsuario(),frm_MantenimientoUsuarios.devolverContraseña(),frm_MantenimientoUsuarios.devolverTipo());
           mensaje("El usuario ha sido agregado exitosamente");
           frm_MantenimientoUsuarios.resetearIntefaz();
           frm_MantenimientoUsuarios.estadoInicial();
           frm_MantenimientoUsuarios.habilitarTF();           
            }
           if(fuente==3)
           {
           metodos.modificarInformacionDelXmlUsuario(frm_MantenimientoUsuarios.devolverInformacion());
           mensaje("El usuario ha sido agregado exitosamente");
           frm_MantenimientoUsuarios.resetearIntefaz();
           frm_MantenimientoUsuarios.estadoInicial();
           frm_MantenimientoUsuarios.habilitarTF();    
           }
           }
            if(e.getActionCommand().equals("Modificar"))
            {
            if(fuente==1)
            {
               metodosUsuarios.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacion());           
               frm_MantenimientoUsuarios.resetearInterfaz();
               mensaje("Se modificó correctamente");
           
            }
            if(fuente==2)
            {
            conexion.actualizarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto(),frm_MantenimientoUsuarios.devolverNombreUsuario(),frm_MantenimientoUsuarios.devolverContraseña(),frm_MantenimientoUsuarios.devolverTipo());
            mensaje("El usuario se modificó exitosamente");
            frm_MantenimientoUsuarios.resetearIntefaz();
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.habilitarTF();
            }
            if(fuente==3)
            {
            metodos.modificarInformacionDelXmlUsuario(frm_MantenimientoUsuarios.devolverInformacion());
            mensaje("El usuario se modificó exitosamente");
            frm_MantenimientoUsuarios.resetearIntefaz();
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.habilitarTF();
            }
            }
            
            if(e.getActionCommand().equals("Consultar"))
            {
             if(fuente==1)
             {
                 if(metodosUsuarios.consultarUsuario(frm_MantenimientoUsuarios.devolverNombreUsuario()))
            {
                frm_MantenimientoUsuarios.mostrarInformacion(metodos.getArregloInformacion());
                mensaje("Se encontró el usuario");
            }
            else
            {
                mensaje("No se encontró el usuario");
            } 
             }
             if(fuente==2)
             {
             if(conexion.consultarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto()))
             {
             frm_MantenimientoUsuarios.mostrarInformacion(conexion.getArregloInformacion());
             frm_MantenimientoUsuarios.habilitarBotones();
             frm_MantenimientoUsuarios.deshabilitarTF();
             }
             else
             {
                 mensaje("El usuario no ha sido registrado");
                 frm_MantenimientoUsuarios.habilitarBotones();
             }
            }
             if(fuente==3)
             {
               if(metodos.consultarInformacionDelXmlUsuarios(frm_MantenimientoUsuarios.devolverNombreCompleto()))
             {
             frm_MantenimientoUsuarios.mostrarInformacion(metodos.getArregloInformacion());
             frm_MantenimientoUsuarios.habilitarBotones();
             frm_MantenimientoUsuarios.deshabilitarTF();
             }
             else
             {
                 mensaje("El usuario no ha sido registrado");
                 frm_MantenimientoUsuarios.habilitarBotones();
             }  
             }
            }
            
          if(e.getActionCommand().equals("Eliminar"))
           {
               if(fuente==1)
               {
                metodosUsuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion());
                frm_MantenimientoUsuarios.resetearInterfaz();
                mensaje("Se eliminó correctamente");
            
            
               }
               if(fuente==2)
               {
            conexion.eliminarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto());
            mensaje("El usuario ha sido eliminado exitosamente");
            frm_MantenimientoUsuarios.resetearIntefaz();
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.habilitarTF();
           }
               if(fuente==3)
               {
            metodos.eliminarInformacionDelXmlUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto());
            mensaje("El usuario ha sido eliminado exitosamente");
            frm_MantenimientoUsuarios.resetearIntefaz();
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.habilitarTF();
               }
           }

    }
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }    
}
