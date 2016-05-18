
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Metodos_XML;
import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    

    Controlador_FRM_MenuPrincipal menuPrincipal;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    ConexionBD conexion;
    Metodos_XML metodos;
    int fuente=0;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        mantenimientoEstudiantes.estadoInicial();
        this.conexion=conexion;
        
    }
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        { 
           if(fuente==1)
           {
               
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
               
           }
        }
           
        if(e.getActionCommand().equals("Agregar"))
        {
         if(fuente==1)
         {
             
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
             
         }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(fuente==1)
            {
                
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
                
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(fuente==1)
            {
                
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
                
            }
        }
    
    }
    
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    
}
