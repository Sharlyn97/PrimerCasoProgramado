
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
    MetodosEstudiantes metodos2;
    int fuente=0;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        mantenimientoEstudiantes.estadoInicial();
        this.conexion=conexion;
        this.metodos=metodos;
        frm_Matricula.controlador.metodosEstudiantes=this.metodos2;
        metodos2=new MetodosEstudiantes();
        archivo=new ArchivoEstudiantes();
        metodos2.setArray(archivo.devolverInformacionDeEstudiantes());
    }
    
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
    public void crearArchivo()
    {
      ArrayList <Estudiante> array=metodos2.getArray();
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
             if(metodos2.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
                mensaje("Se encontó el estudiante");
            }
            else
            {
                mensaje("No se encontró el estudiante");
            }
           }
           if(fuente==2)
           {
            if(conexion.consultarEstudiantes(mantenimientoEstudiantes.devolverCedula()))
           {
           mantenimientoEstudiantes.mostrarInformacion(conexion.getArregloInformacion());
           mantenimientoEstudiantes.habilitarBotones();
           mantenimientoEstudiantes.deshabilitarTF();
           }
           else
           {
               mensaje("El estudiante no ha sido registrado");
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
           }
           else
           {
               mensaje("El estudiante no ha sido registrado");
               mantenimientoEstudiantes.habilitarBotones();
           }   
           }
        }
           
        if(e.getActionCommand().equals("Agregar"))
        {
         if(fuente==1)
         {
             if(metodos2.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion(),mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.resetearInterfaz();
                mensaje("Se agregó correctamente");
            }
            else
            {
                mensaje("No se encontró el curso");
            }
         }
         if(fuente==2)
         {
         conexion.registrarEstudiante(mantenimientoEstudiantes.devolverCedula(),mantenimientoEstudiantes.devolverNombre(),mantenimientoEstudiantes.devolverDireccion());
         mensaje("El estudiante ha sido agregado exitosamente");
         mantenimientoEstudiantes.resetearInterfaz();
         mantenimientoEstudiantes.habilitarTF();
         }
         if(fuente==3)
         {
         metodos.guardarEnXMLEstudiantes(mantenimientoEstudiantes.devolverInformacion());
         mensaje("El estudiante ha sido agregado exitosamente");
         mantenimientoEstudiantes.resetearInterfaz();
         mantenimientoEstudiantes.habilitarTF();
         }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(fuente==1)
            {
               if(metodos2.modificarEstudiante(mantenimientoEstudiantes.devolverCedula(), mantenimientoEstudiantes.devolverNombre(), mantenimientoEstudiantes.devolverDireccion()))
           {
               mantenimientoEstudiantes.resetearInterfaz();
               mensaje("Se modificó correctamente");
           }
           else
            {
               mensaje("No se encontró el curso");
            } 
            }
            if(fuente==2)
            {
            conexion.actualizarEstudiante(mantenimientoEstudiantes.devolverCedula(),mantenimientoEstudiantes.devolverNombre(),mantenimientoEstudiantes.devolverDireccion());
            mensaje("El estudiante se modificó exitosamente");
            mantenimientoEstudiantes.resetearInterfaz();
            mantenimientoEstudiantes.estadoInicial();
            mantenimientoEstudiantes.habilitarTF();
            }
            if(fuente==3)
            {
            metodos.modificarInformacionDelXmlEstudiantes(mantenimientoEstudiantes.devolverInformacion());
            mensaje("El estudiante se modificó exitosamente");
            mantenimientoEstudiantes.resetearInterfaz();
            mantenimientoEstudiantes.estadoInicial();
            mantenimientoEstudiantes.habilitarTF();
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(fuente==1)
            {
              if(metodos2.eliminarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.resetearInterfaz();
                mensaje("Se eliminó correctamente");
            }
            else
            {
                mensaje("No se encontró el curso");
            }  
            }
            if(fuente==2)
            {
            conexion.eliminarEstudiante(mantenimientoEstudiantes.devolverCedula());
            mensaje("El estudiante ha sido eliminado exitosamente");
            mantenimientoEstudiantes.resetearInterfaz();
            mantenimientoEstudiantes.estadoInicial();
            mantenimientoEstudiantes.habilitarTF();
            }
            if(fuente==3)
            {
            metodos.eliminarInformacionDelXmlEstudiantes((mantenimientoEstudiantes.devolverCedula()));
            mensaje("El estudiante ha sido eliminado exitosamente");
            mantenimientoEstudiantes.resetearInterfaz();
            mantenimientoEstudiantes.estadoInicial();
            mantenimientoEstudiantes.habilitarTF();
            }
        }
    
    }
    
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
}
