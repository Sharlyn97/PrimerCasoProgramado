
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


public class Controlador_FRM_MantenimientoUsuarios implements ActionListener{
    
FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
FRM_Login login;
ConexionBD conexion;
Metodos_XML metodos;
MetodosUsuarios metodosUsuarios;
public ArchivoUsuarios archivo;
int fuente=0;

    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frm_MantenimientoUsuarios,FRM_Login login) //
    {
        this.frm_MantenimientoUsuarios=frm_MantenimientoUsuarios;
        this.conexion=conexion;
        this.metodos=metodos;
        archivo=new ArchivoUsuarios();  
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
         //System.out.println("ingresa la información: "+array.get(conta).getNombreUsuario()+array.get(conta).getNombre()+array.get(conta).getContraseña());
         archivo.devolverInformacionDeUsuario();
     }   
     
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Agregar"))
        {   
           if(fuente==1)
           {
                if(metodosUsuarios.agregarUsuario(frm_MantenimientoUsuarios.devolverInformacion()))
                {
                    frm_MantenimientoUsuarios.resetearInterfaz();
                    frm_MantenimientoUsuarios.mensaje("Se agregó correctamente");
                    crearArchivo();
                }
                else
                {
                    frm_MantenimientoUsuarios.mensaje("Hubo un problema al agregar el usuario, intente nuevamente");
                }
           } 
           if(fuente==2)
           {
                if(conexion.registrarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto(),frm_MantenimientoUsuarios.devolverNombreUsuario(),frm_MantenimientoUsuarios.devolverContraseña(),frm_MantenimientoUsuarios.devolverTipo()))
                {
                    frm_MantenimientoUsuarios.mensaje("El usuario ha sido agregado exitosamente");
                    frm_MantenimientoUsuarios.resetearIntefaz();
                    frm_MantenimientoUsuarios.estadoInicial();
                    frm_MantenimientoUsuarios.habilitarTF();           
                }
               else
               {
                   frm_MantenimientoUsuarios.mensaje("Hubo un problema al agregar el usuario, intente nuevamente");
               }
           } 
           if(fuente==3)
           {
                if(metodos.guardarEnXMLUsuarios(frm_MantenimientoUsuarios.devolverInformacion()))
                {
                frm_MantenimientoUsuarios.mensaje("El usuario ha sido agregado exitosamente");
                frm_MantenimientoUsuarios.resetearIntefaz();
                frm_MantenimientoUsuarios.estadoInicial();
                frm_MantenimientoUsuarios.habilitarTF();    
                }
                else
                {
                    frm_MantenimientoUsuarios.mensaje("Hubo un problema al agregar el usuario, intente nuevamente");
                }
           }
         }
            if(e.getActionCommand().equals("Modificar"))
            {
                if(fuente==1)
                {
                   if(metodosUsuarios.modificarUsuario(frm_MantenimientoUsuarios.devolverInformacion()))
                    {
                    frm_MantenimientoUsuarios.resetearInterfaz();
                    frm_MantenimientoUsuarios.mensaje("Se modificó correctamente");
                    }
                    else
                    {
                        frm_MantenimientoUsuarios.mensaje("No se pudo modificar correctamente");
                    }
                }
            if(fuente==2)
            {
                if(conexion.actualizarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto(),frm_MantenimientoUsuarios.devolverNombreUsuario(),frm_MantenimientoUsuarios.devolverContraseña(),frm_MantenimientoUsuarios.devolverTipo()))
                {
                    frm_MantenimientoUsuarios.mensaje("El usuario se modificó exitosamente");
                    frm_MantenimientoUsuarios.resetearIntefaz();
                    frm_MantenimientoUsuarios.estadoInicial();
                    frm_MantenimientoUsuarios.habilitarTF();
                }
                else
                {
                    frm_MantenimientoUsuarios.mensaje("No se pudo modificar correctamente");
                }
            }
            if(fuente==3)
            {
                if(metodos.modificarInformacionDelXmlUsuario(frm_MantenimientoUsuarios.devolverInformacion()))
                {
                    frm_MantenimientoUsuarios.mensaje("El usuario se modificó exitosamente");
                    frm_MantenimientoUsuarios.resetearIntefaz();
                    frm_MantenimientoUsuarios.estadoInicial();
                    frm_MantenimientoUsuarios.habilitarTF();
                }
                else
                {
                    frm_MantenimientoUsuarios.mensaje("No se pudo modificar correctamente");
                }
            }
         }   
            if(e.getActionCommand().equals("Consultar"))
            {
             if(fuente==1)
             {
                 
                 if(metodosUsuarios.consultarUsuario(frm_MantenimientoUsuarios.devolverNombreUsuario()))
               {
                frm_MantenimientoUsuarios.mostrarInformacion(metodosUsuarios.getArregloInformacion());
                frm_MantenimientoUsuarios.mensaje("Se encontró el usuario");
                }
            else
            {
                frm_MantenimientoUsuarios.mensaje("El usuario no ha sido registrado");
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
                 frm_MantenimientoUsuarios.mensaje("El usuario no ha sido registrado");
                 frm_MantenimientoUsuarios.habilitarBotones();
             }
            }
             if(fuente==3)
             {
               if(metodos.consultarInformacionDelXmlUsuarios(frm_MantenimientoUsuarios.devolverNombreUsuario()))
             {
             frm_MantenimientoUsuarios.mostrarInformacion(metodos.getArregloInformacion());
             frm_MantenimientoUsuarios.habilitarBotones();
             frm_MantenimientoUsuarios.deshabilitarTF();
             }
             else
             {
                 frm_MantenimientoUsuarios.mensaje("El usuario no ha sido registrado");
                 frm_MantenimientoUsuarios.habilitarBotones();
             }  
             }
          }
            
          if(e.getActionCommand().equals("Eliminar"))
           {
               if(fuente==1)
               {
                    if(metodosUsuarios.eliminarUsuario(frm_MantenimientoUsuarios.devolverInformacion()))
                    {
                        frm_MantenimientoUsuarios.resetearInterfaz();
                        frm_MantenimientoUsuarios.mensaje("Se eliminó correctamente");
                    }
                   else
                   {
                       frm_MantenimientoUsuarios.mensaje("No se pudo eliminar al usuario");
                   }
               }  
               if(fuente==2)
               {
                    if(conexion.eliminarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto()))
                    {
                        frm_MantenimientoUsuarios.mensaje("El usuario ha sido eliminado exitosamente");
                        frm_MantenimientoUsuarios.resetearIntefaz();
                        frm_MantenimientoUsuarios.estadoInicial();
                        frm_MantenimientoUsuarios.habilitarTF();
                    }
                    else
                    {
                        frm_MantenimientoUsuarios.mensaje("No se pudo eliminar el usuario");
                    }
               }    
               if(fuente==3)
               {
                   if(metodos.eliminarInformacionDelXmlUsuario(frm_MantenimientoUsuarios.devolverNombreUsuario()))
                   {
                        frm_MantenimientoUsuarios.mensaje("El usuario ha sido eliminado exitosamente");
                        frm_MantenimientoUsuarios.resetearIntefaz();
                        frm_MantenimientoUsuarios.estadoInicial();
                        frm_MantenimientoUsuarios.habilitarTF();
                   }
                    else
                    {
                        frm_MantenimientoUsuarios.mensaje("No se pudo eliminar el usuario");
                    }
               }

            }
       }
}
