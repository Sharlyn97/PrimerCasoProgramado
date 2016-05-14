/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_Matricula implements ActionListener{
    
    FRM_Matricula frm_Matricula;
    boolean encontroEstudiante=false; 
    boolean encontroCurso=false;
    ConexionBD conexion;
    
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula)
    {
        this.frm_Matricula=frm_Matricula;
        this.conexion=conexion;
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("ConsultaRapidaEstudiante"))
        {
            if(conexion.consultarEstudiantes(frm_Matricula.devolverCedula()))
            {
                String arreglo[]=conexion.getArregloInformacion();
                frm_Matricula.mostrarNombreEstudiante(arreglo[0]);
                encontroEstudiante=true;        
            }
            else
            {
                frm_Matricula.mostrarMensaje("El estudiante consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Estudiantes");
            }
        }
        if(e.getActionCommand().equals("ConsultaRapidaCurso"))
        {
           if(conexion.consultarCurso(frm_Matricula.devolverSigla()))
            {
                String arreglo[]=conexion.getArregloInformacion();
                frm_Matricula.mostrarNombreCurso(arreglo[0]);
                encontroCurso=true;
            }
            else
            {
                frm_Matricula.mostrarMensaje("El curso consultado no se encuentra, favor dirigirse al módulo de Mantenimiento Cursos");
            } 
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(conexion.consultarMatricula(frm_Matricula.devolverCodigo()))
            {
                String arreglo[]=conexion.getArregloInformacion();  
                
                     
            }
            else
            {
              frm_Matricula.mostrarMensaje("El código consultado, no tiene ninguna matricula registrada");  
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {  
            //frm_Matricula.cargarTabla();
            //encontroCurso=false;
            frm_Matricula.estadoInicial();
            frm_Matricula.limpiarCurso(); 
            
            
        }
        if(e.getActionCommand().equals("Finalizar"))
        {  
            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
               conexion.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
            }
            frm_Matricula.resetearInterfaz();
            conexion.devolverCodigo();
            
          //  metodosMatricula.mostrarInformacion();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            conexion.eliminarMatricula(frm_Matricula.devolverCodigo());
            frm_Matricula.resetearInterfaz();
            conexion.devolverCodigo();
        }
        if(encontroEstudiante && encontroCurso)
        {
            frm_Matricula.habilitarAgregar();
        }
    }
    
    public String colocarCodigo()
    {
        return conexion.devolverCodigo();
    }
}
