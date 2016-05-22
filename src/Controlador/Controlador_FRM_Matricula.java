/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivoMatricula;
import Modelo.ConexionBD;
import Modelo.Matricula;
import Modelo.MetodosCursos;
import Modelo.MetodosEstudiantes;
import Modelo.MetodosMatricula;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.Metodos_XML;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesse y Sharlyn
 */
public class Controlador_FRM_Matricula implements ActionListener{
    
    FRM_Matricula frm_Matricula;
    boolean encontroEstudiante=false; 
    boolean encontroCurso=false;
    ConexionBD conexion;
    Metodos_XML metodos;  
    ArchivoMatricula archivo;
    MetodosMatricula metodosMatricula;
    MetodosEstudiantes metodosEstudiantes;
    MetodosCursos metodosCursos;
    
    public int fuente=0;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula)
    {
        this.frm_Matricula=frm_Matricula;
        this.conexion=conexion;
        this.metodos=metodos;
        this.metodosEstudiantes=metodosEstudiantes;
        this.metodosCursos=metodosCursos;
        archivo=new ArchivoMatricula();
        metodosMatricula=new MetodosMatricula();
        metodosMatricula.setArray(archivo.devolverInformacionDeMatricula());
        
    }
    
    public void crearArchivo()
    {
      ArrayList <Matricula> array=metodosMatricula.getArray();
     archivo.crearArchivoMatricula();
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivo.ingresarInformacionMatricula(array.get(conta));         
         archivo.devolverInformacionDeMatricula();
     }   
     
    }    
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante"))
        {
            if(fuente==1)
            {
                if(metodosEstudiantes.consultarEstudiante(frm_Matricula.devolverCedula()))
                {
                    String arreglo[]=metodosEstudiantes.getArregloInformacion();
                    frm_Matricula.mostrarNombreEstudiante(arreglo[1]);
                    frm_Matricula.mostrarMensaje("Se encontró el estudiante");
                    encontroEstudiante=true;        
                }
                else
                {
                    frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(fuente==2)
            {
                if(conexion.consultarEstudiantes(frm_Matricula.devolverCedula()))
                {
                    String arreglo[]=conexion.getArregloInformacion();
                    frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                    frm_Matricula.mostrarMensaje("Se encontró el estudiante");
                    encontroEstudiante=true;        
                }
                else
                {
                    frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
                }
            }
            if(fuente==3)
            {
                if(metodos.consultarInformacionDelXmlEstudiantes(frm_Matricula.devolverCedula()))
              {
                  String arreglo[]=metodos.getArregloInformacion();
                  frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                  frm_Matricula.mostrarMensaje("Se encontró el estudiante");
                  encontroEstudiante=true;        
              }
              else
              {
                  frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
              }  
            }
        }
        if(e.getActionCommand().equals("ConsultaRapidaCurso"))
        {
           if(fuente==1)
           {
                if(metodosCursos.consultarCurso(frm_Matricula.devolverSigla()))
             {
                 String arreglo[]=metodosCursos.getArregloInformacion();
                 frm_Matricula.mostrarNombreCurso(arreglo[0]);
                 frm_Matricula.mostrarMensaje("Se encontró el curso");
                 encontroCurso=true;
             }
             else
             {
                 frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
             } 
           }
           if(fuente==2)
           {
            if(conexion.consultarCurso(frm_Matricula.devolverSigla()))
             {
                 String arreglo[]=conexion.getArregloInformacionCurso();
                 frm_Matricula.mostrarNombreCurso(arreglo[0]);
                 frm_Matricula.mostrarMensaje("Se encontró el curso");
                 encontroCurso=true;
             }
             else
             {
                 frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
             } 
           }
           if(fuente==3)
           {
                if(metodos.consultarInformacionDelXmlCursos(frm_Matricula.devolverSigla()))
              {
                  String arreglo[]=metodos.getArregloInformacion();
                  frm_Matricula.mostrarNombreCurso(arreglo[0]);
                  frm_Matricula.mostrarMensaje("Se encontró el curso");
                  encontroCurso=true;
              }
              else
              {
                  frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
              }  
           }
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(fuente==1)
            {
                if(metodosMatricula.consultarMatricula(frm_Matricula.devolverCodigo()))
             {
                frm_Matricula.mostrarInformacion(metodosMatricula.getArregloInformacion());
                frm_Matricula.mostrarNombreEstudiante(metodosEstudiantes.consultarNombreEstudiante(frm_Matricula.devolverCedula()));
                frm_Matricula.mostrarNombreCurso(metodosMatricula.consultarSiglaCurso(frm_Matricula.devolverCodigo()));
                frm_Matricula.cargarTabla();
                frm_Matricula.habilitarModiEliminar();
                metodosMatricula.devolverCodigo();
                //frm_Matricula.habilitarAgregar();
                frm_Matricula.mostrarMensaje("Se encontró la matricula");

             }
             else
             {
               frm_Matricula.mostrarMensaje("La matricula no existe");
               frm_Matricula.habilitarAgregar();
               metodosMatricula.devolverCodigo();
             } 
            }
            if(fuente==2)
            {
                if((conexion.consultarMatricula(frm_Matricula.devolverCodigo()))&&(conexion.consultarMatriculaConCurso(frm_Matricula.devolverCodigo())))
                {
       
                   frm_Matricula.mostrarInformacion(conexion.getArregloInformacionMatricula());
                   frm_Matricula.mostrarNombreEstudiante(conexion.consultarNombreEstudiantes(frm_Matricula.devolverCedula()));
                   frm_Matricula.mostrarNombreCurso(conexion.consultarNombreCurso(frm_Matricula.devolverSigla()));
                   frm_Matricula.cargarTabla();
                   frm_Matricula.habilitarModiEliminar();
                   conexion.devolverCodigo();
                   frm_Matricula.mostrarMensaje("Se encontró la matricula");

                }
                else
                {
                  frm_Matricula.mostrarMensaje("La matricula no existe");
                  frm_Matricula.habilitarAgregar();
                  conexion.devolverCodigo();
                }
        }
            if(fuente==3)
            {
                if(metodos.consultarInformacionDelXmlMatricula(frm_Matricula.devolverCodigo()))
              {
                 frm_Matricula.mostrarInformacion(metodos.getArregloInformacion());
                 frm_Matricula.mostrarNombreEstudiante(metodos.consultarInformacionEstudiantes(frm_Matricula.devolverCedula()));
                 frm_Matricula.mostrarNombreCurso(frm_Matricula.devolverSigla());
                 frm_Matricula.cargarTabla();
                 frm_Matricula.habilitarModiEliminar();
                 metodos.colocarCodigo();
                 frm_Matricula.mostrarMensaje("Se encontró la matricula");

              }
              else
              {
                frm_Matricula.mostrarMensaje("La matricula no existe");
                frm_Matricula.habilitarAgregar();
                metodos.colocarCodigo();
              }
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {  
            frm_Matricula.cargarTabla();
            frm_Matricula.estadoInicial();
            //frm_Matricula.limpiarCurso(); 
        }
        if(e.getActionCommand().equals("Finalizar"))
        {  
            if(fuente==1)
            {
                for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
               {
                   metodosMatricula.agregarMatricula(frm_Matricula.getInformacionTabla(contador));
               }
               frm_Matricula.resetearInterfaz();
               metodosMatricula.devolverCodigo();  
               frm_Matricula.mostrarMensaje("Matricula finalizada");
               crearArchivo();
            }
            if(fuente==2)
            {
                for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
                {
                    conexion.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
                }
                frm_Matricula.resetearInterfaz();
                conexion.devolverCodigo();
                frm_Matricula.mostrarMensaje("Matricula finalizada");
            }
            if(fuente==3)
            {
                for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
                {
                    metodos.guardarEnXMLMatricula(frm_Matricula.getInformacionTabla(contador));
                }
                frm_Matricula.resetearInterfaz();
                metodos.colocarCodigo(); 
                frm_Matricula.mostrarMensaje("Matricula finalizada");
            }
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            if(fuente==1)
            {
                if(metodosMatricula.eliminarMatricula(frm_Matricula.devolverCodigo()))
                {
                    frm_Matricula.resetearInterfaz();
                    metodosMatricula.devolverCodigo(); 
                    frm_Matricula.mostrarMensaje("La matricula eliminó correctamente");
                }
                else
                {
                    frm_Matricula.mostrarMensaje("No se eliminó correctamente"); 
                }
            }
            if(fuente==2)
            {
                if(conexion.eliminarMatricula(frm_Matricula.devolverCodigo()))
                {
                    frm_Matricula.resetearInterfaz();
                    conexion.devolverCodigo();
                    frm_Matricula.mostrarMensaje("La matricula eliminó correctamente");
                }
                else
                {
                    frm_Matricula.mostrarMensaje("No se eliminó correctamente"); 
                }
            }
            if(fuente==3)
            {
               if(metodos.eliminarInformacionDelXmlMatricula(frm_Matricula.devolverCodigo()))
               {
                    frm_Matricula.resetearInterfaz();
                    metodos.colocarCodigo();
                    frm_Matricula.mostrarMensaje("La matricula eliminó correctamente");
               }
               else
               {
                    frm_Matricula.mostrarMensaje("No se eliminó correctamente");  
               }
            }
        
        if(encontroEstudiante && encontroCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
        
    }
  }
    public String colocarCodigoXML()
    {
        return metodos.colocarCodigo();
    }
    
     public String colocarCodigoBaseDatos()
    {
        return conexion.devolverCodigo();
    }
     
     public String colocarCodigoArchivos()
    {
        return metodosMatricula.devolverCodigo();
    }
    

}

