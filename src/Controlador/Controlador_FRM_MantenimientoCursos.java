/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ArchivoCursos;
import Modelo.ConexionBD;
import Modelo.Cursos;
import Modelo.Estudiante;
import Modelo.MetodosCursos;
import Modelo.Metodos_XML;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_Matricula;
import Vista.FRM_MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesse
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    FRM_Matricula frm_Matricula;
    ConexionBD conexion;
    Metodos_XML metodos;
    MetodosCursos metodosCursos;
    ArchivoCursos archivo;
    int fuente=0;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos= frm_MantenimientoCursos;
        this.conexion=conexion;
        this.metodos=metodos;
        archivo=new ArchivoCursos();
        metodosCursos=new MetodosCursos();
        frm_MantenimientoCursos.estadoInicial();
        metodosCursos.setArray(archivo.devolverInformacionDeCursos());
    } 
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
    public void crearArchivo()
    {
      ArrayList <Cursos> array=metodosCursos.getArray();
     archivo.crearArchivoCursos();
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivo.ingresarInformacionCursos(array.get(conta));
         archivo.devolverInformacionDeCursos();
     }   
     
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
            if(fuente==1)
            {
              if(metodosCursos.agregarCurso(frm_MantenimientoCursos.devolverInformacion()))
               {
                frm_MantenimientoCursos.resetearInterfaz();
                frm_MantenimientoCursos.mensaje("Se agregó correctamente");
                crearArchivo();
               }
                else
                {
                    frm_MantenimientoCursos.mensaje("No se agregó el curso");
                }  
            }
            if(fuente==2)
            {
                    if(conexion.registrarCurso(frm_MantenimientoCursos.devolverSigla(),frm_MantenimientoCursos.devolverNombre(),frm_MantenimientoCursos.devolverCreditos(),frm_MantenimientoCursos.devolverHorario()))
                    {
                    frm_MantenimientoCursos.resetearInterfaz();
                    frm_MantenimientoCursos.estadoInicial();
                    frm_MantenimientoCursos.habilitarTF();
                    frm_MantenimientoCursos.mensaje("Se agregó correctamente");
                   }
                else
                {
                    frm_MantenimientoCursos.mensaje("No se agregó correctamente");
                }
           }
            if(fuente==3)
            {
                if(metodos.guardarEnXMLCurso(frm_MantenimientoCursos.devolverInformacion()))
                {
                 frm_MantenimientoCursos.resetearInterfaz();
                 frm_MantenimientoCursos.estadoInicial();
                 frm_MantenimientoCursos.habilitarTF();
                 frm_MantenimientoCursos.mensaje("Se agregó correctamente");
                }
                else
             {
                 frm_MantenimientoCursos.mensaje("No se agregó correctamente");
             }
            }    
        }
        if(e.getActionCommand().equals("Consultar"))
        {
          if(fuente==1)
          {
              if(metodosCursos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodosCursos.getArregloInformacion());
                frm_MantenimientoCursos.mensaje("Se encontró el curso");
            }
            else
            {
                frm_MantenimientoCursos.mensaje("No se encontró el curso");
                frm_MantenimientoCursos.habilitarBotones();
            }
          }
          if(fuente==2)
          {
            if(conexion.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
             frm_MantenimientoCursos.mostrarInformacion(conexion.retornarCursos());
             frm_MantenimientoCursos.habilitarBotones();
             frm_MantenimientoCursos.deshabilitarTF();
             frm_MantenimientoCursos.mensaje("Se consultó correctamente");
            }
            else
            {
                frm_MantenimientoCursos.mensaje("El curso no sido registrado");
                frm_MantenimientoCursos.habilitarBotones();
            }
          }
          if(fuente==3)
          {
             if(metodos.consultarInformacionDelXmlCursos(frm_MantenimientoCursos.devolverSigla()))
            {
             frm_MantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
             frm_MantenimientoCursos.habilitarBotones();
             frm_MantenimientoCursos.deshabilitarTF();
             frm_MantenimientoCursos.mensaje("Se consultó correctamente");
            }
            else
            {
                frm_MantenimientoCursos.mensaje("El curso no sido registrado");
                frm_MantenimientoCursos.habilitarBotones();
            }
          }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            if(fuente==1)
            {
                if(metodosCursos.modificarCurso(frm_MantenimientoCursos.devolverInformacion()))
                {
                    frm_MantenimientoCursos.resetearInterfaz();
                    frm_MantenimientoCursos.mensaje("Se modificó correctamente");
                }
                else
                 {
                    frm_MantenimientoCursos.mensaje("No se encontró el curso");
                 } 
            }
            if(fuente==2)
            {
                if(conexion.actualizarCursos(frm_MantenimientoCursos.devolverSigla(),frm_MantenimientoCursos.devolverNombre(),frm_MantenimientoCursos.devolverCreditos(),frm_MantenimientoCursos.devolverHorario()))
                {
                    frm_MantenimientoCursos.mensaje("El curso se modificó exitosamente");
                    frm_MantenimientoCursos.resetearInterfaz();
                    frm_MantenimientoCursos.estadoInicial();
                    frm_MantenimientoCursos.habilitarTF();
                }
                else
                {
                    frm_MantenimientoCursos.mensaje("No se encontró el curso");
                }
            }
            if(fuente==3)
            {
                if(metodos.modificarInformacionDelXmlCursos(frm_MantenimientoCursos.devolverInformacion()))
                {
                    frm_MantenimientoCursos.mensaje("El curso se modificó exitosamente");
                    frm_MantenimientoCursos.resetearInterfaz();
                    frm_MantenimientoCursos.estadoInicial();
                    frm_MantenimientoCursos.habilitarTF();
                }
                else
                {
                    frm_MantenimientoCursos.mensaje("No se encontró el curso");
                }  
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(fuente==1)
            {
                if(metodosCursos.eliminarCurso(frm_MantenimientoCursos.devolverSigla()))
               {
                frm_MantenimientoCursos.resetearInterfaz();
                frm_MantenimientoCursos.mensaje("Se eliminó correctamente");
               }
                else
                {
                    frm_MantenimientoCursos.mensaje("No se encontró el curso");
                }  
            }
            if(fuente==2)
            {
                if(conexion.eliminarCurso(frm_MantenimientoCursos.devolverSigla()))
                {
                frm_MantenimientoCursos.mensaje("El curso ha sido eliminado exitosamente");
                frm_MantenimientoCursos.resetearInterfaz();
                frm_MantenimientoCursos.estadoInicial();
                frm_MantenimientoCursos.habilitarTF();
                }
                else
                {
                    frm_MantenimientoCursos.mensaje("No se encontró el curso");
                }
            }
            if(fuente==3)
            {
               if(metodos.eliminarInformacionDelXmlCurso(frm_MantenimientoCursos.devolverSigla()))
               {
                frm_MantenimientoCursos.mensaje("El curso ha sido eliminado exitosamente");
                frm_MantenimientoCursos.resetearInterfaz();
                frm_MantenimientoCursos.estadoInicial();
                frm_MantenimientoCursos.habilitarTF(); 
               }
               else
                {
                    frm_MantenimientoCursos.mensaje("No se encontró el curso");
                }
            }
        }
    }
}
