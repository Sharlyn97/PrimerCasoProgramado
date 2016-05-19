
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoEstudiantes;
import Modelo.ConexionBD;
import Modelo.Estudiante;
import Modelo.MetodosEstudiantes;
import Modelo.Metodos_XML;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    

    Controlador_FRM_MenuPrincipal menuPrincipal;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_Matricula frm_Matricula;
    ConexionBD conexion;
    Metodos_XML metodos;
    ArchivoEstudiantes archivo;
    public MetodosEstudiantes metodosEstudiantes;
    int fuente=0;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        mantenimientoEstudiantes.estadoInicial();
        this.conexion=conexion;
        this.metodos=metodos;
        metodosEstudiantes=new MetodosEstudiantes();
        archivo=new ArchivoEstudiantes();
        metodosEstudiantes.setArray(archivo.devolverInformacionDeEstudiantes());
        
    }
    
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
    public void crearArchivo()
    {
      ArrayList <Estudiante> array=metodosEstudiantes.getArray();
     archivo.crearArchivoEstudiantes();
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivo.ingresarInformacionEstudiantes(array.get(conta));
         System.out.println("ingresa la información: "+array.get(conta).getCedula()+array.get(conta).getDireccion()+array.get(conta).getNombreCompleto());
         archivo.devolverInformacionDeEstudiantes();
     }   
     
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        { 
           if(fuente==1)
           {
             if(metodosEstudiantes.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
                mantenimientoEstudiantes.mensaje("Se encontó el estudiante");
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
            }
           }
           if(fuente==2)
           {
            if(conexion.consultarEstudiantes(mantenimientoEstudiantes.devolverCedula()))
           {
           mantenimientoEstudiantes.mostrarInformacion(conexion.getArregloInformacion());
           mantenimientoEstudiantes.habilitarBotones();
           mantenimientoEstudiantes.deshabilitarTF();
           mantenimientoEstudiantes.mensaje("Se encontró al estudiante");
           }
           else
           {
               mantenimientoEstudiantes.mensaje("El estudiante no ha sido registrado");
               mantenimientoEstudiantes.habilitarBotones();
           }
       
        }
           if(fuente==3)
           {
            if(metodos.consultarInformacionDelXmlEstudiantes(mantenimientoEstudiantes.devolverCedula()))
           {
           mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
           mantenimientoEstudiantes.habilitarBotones();
           mantenimientoEstudiantes.deshabilitarTF();
           mantenimientoEstudiantes.mensaje("Se encontró al estudiante");
           }
           else
           {
               mantenimientoEstudiantes.mensaje("El estudiante no ha sido registrado");
               mantenimientoEstudiantes.habilitarBotones();
           }   
           }
        }
           
        if(e.getActionCommand().equals("Agregar"))
        {
         if(fuente==1)
         {
             if(metodosEstudiantes.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion(),mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.resetearInterfaz();
                mantenimientoEstudiantes.mensaje("Se agregó correctamente");
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se agregó correctamente");
            }
         }
         if(fuente==2)
         {
            if(conexion.registrarEstudiante(mantenimientoEstudiantes.devolverCedula(),mantenimientoEstudiantes.devolverNombre(),mantenimientoEstudiantes.devolverDireccion()))
            {
                mantenimientoEstudiantes.mensaje("El estudiante ha sido agregado exitosamente");
                mantenimientoEstudiantes.resetearInterfaz();
                mantenimientoEstudiantes.habilitarTF();
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se agregó correctamente");
            }
         }
         if(fuente==3)
         {
            if(metodos.guardarEnXMLEstudiantes(mantenimientoEstudiantes.devolverInformacion()))
            {
                mantenimientoEstudiantes.mensaje("El estudiante ha sido agregado exitosamente");
                mantenimientoEstudiantes.resetearInterfaz();
                mantenimientoEstudiantes.habilitarTF();
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se agregó correctamente");
            }
          }
        } 
        if(e.getActionCommand().equals("Modificar"))
        {
            if(fuente==1)
            {
               if(metodosEstudiantes.modificarEstudiante(mantenimientoEstudiantes.devolverCedula(), mantenimientoEstudiantes.devolverNombre(), mantenimientoEstudiantes.devolverDireccion()))
              {
               mantenimientoEstudiantes.resetearInterfaz();
               mantenimientoEstudiantes.mensaje("Se modificó correctamente");
              }
              else
             {
                mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
             } 
            }
            if(fuente==2)
            {
                if(conexion.actualizarEstudiante(mantenimientoEstudiantes.devolverCedula(),mantenimientoEstudiantes.devolverNombre(),mantenimientoEstudiantes.devolverDireccion()))
                {
                    mantenimientoEstudiantes.mensaje("El estudiante se modificó exitosamente");
                    mantenimientoEstudiantes.resetearInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    mantenimientoEstudiantes.habilitarTF();
                }
            
                else
                {
                    mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
                }
            }
            if(fuente==3)
            {
                if(metodos.modificarInformacionDelXmlEstudiantes(mantenimientoEstudiantes.devolverInformacion()))
                {
                    mantenimientoEstudiantes.mensaje("El estudiante se modificó exitosamente");
                    mantenimientoEstudiantes.resetearInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    mantenimientoEstudiantes.habilitarTF();
                }
            
                else
                {
                    mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
                }
            }     
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(fuente==1)
            {
              if(metodosEstudiantes.eliminarEstudiante(mantenimientoEstudiantes.devolverCedula()))
              {
                mantenimientoEstudiantes.resetearInterfaz();
                mantenimientoEstudiantes.mensaje("Se eliminó correctamente");
              }
                else
                {
                    mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
                }  
            }
            if(fuente==2)
            {
                if(conexion.eliminarEstudiante(mantenimientoEstudiantes.devolverCedula()))
                {
                    mantenimientoEstudiantes.mensaje("El estudiante ha sido eliminado exitosamente");
                    mantenimientoEstudiantes.resetearInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    mantenimientoEstudiantes.habilitarTF();
                }
                else
                {
                    mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
                }
            }   
            if(fuente==3)
            {
                if(metodos.eliminarInformacionDelXmlEstudiantes((mantenimientoEstudiantes.devolverCedula())))
                {
                    mantenimientoEstudiantes.mensaje("El estudiante ha sido eliminado exitosamente");
                    mantenimientoEstudiantes.resetearInterfaz();
                    mantenimientoEstudiantes.estadoInicial();
                    mantenimientoEstudiantes.habilitarTF();
                }
                else
                {
                    mantenimientoEstudiantes.mensaje("No se encontró al estudiante");
                }
            }
    
        }
        if(e.getActionCommand().equals("ConsultaRapida"))
        { 
             if(fuente==1)
           {
             if(metodosEstudiantes.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
                mantenimientoEstudiantes.mensaje("Se encontó el estudiante");
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
            }
           }
           if(fuente==2)
           {
            if(conexion.consultarEstudiantes(mantenimientoEstudiantes.devolverCedula()))
           {
           mantenimientoEstudiantes.mostrarInformacion(conexion.getArregloInformacion());
           mantenimientoEstudiantes.habilitarBotones();
           mantenimientoEstudiantes.deshabilitarTF();
           mantenimientoEstudiantes.mensaje("Se encontró al estudiante");
           }
           else
           {
               mantenimientoEstudiantes.mensaje("El estudiante no ha sido registrado");
               mantenimientoEstudiantes.habilitarBotones();
           }
       
        }
           if(fuente==3)
           {
                if(metodos.consultarInformacionDelXmlEstudiantes(mantenimientoEstudiantes.devolverCedula()))
               {
               mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
               mantenimientoEstudiantes.habilitarBotones();
               mantenimientoEstudiantes.deshabilitarTF();
               mantenimientoEstudiantes.mensaje("Se encontró al estudiante");
               }
               else
               {
                   mantenimientoEstudiantes.mensaje("El estudiante no ha sido registrado");
                   mantenimientoEstudiantes.habilitarBotones();
               }   
           }
        
        }
    }
}    
