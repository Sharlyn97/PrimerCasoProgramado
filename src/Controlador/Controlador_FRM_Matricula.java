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
import Modelo.Metodos_XML;
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
    
    int fuente=0;
    public Controlador_FRM_Matricula(FRM_MantenimientoEstudiantes mantenimientoEstudiantes,FRM_MantenimientoCursos mantenimientoCursos,FRM_Matricula frm_Matricula)
    {
        this.frm_Matricula=frm_Matricula;
        this.conexion=conexion;
        this.metodos=metodos;
    }
    public void setFuente(int fuente)
    {
        this.fuente=fuente;
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
               frm_Matricula.mostrarInformacion(conexion.getArregloInformacionMatricula());
               frm_Matricula.mostrarNombreEstudiante(conexion.consultarNombreEstudiantes(frm_Matricula.devolverCedula()));
               frm_Matricula.mostrarNombreCurso(conexion.consultarSiglaCurso(frm_Matricula.devolverCodigo()));
               frm_Matricula.cargarTabla();
               frm_Matricula.habilitarModiEliminar();
               conexion.devolverCodigo();

            }
            else
            {
              mensaje("El estudiante no ha sido registrado");
              frm_Matricula.habilitarAgregar();
              conexion.devolverCodigo();
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {  
            frm_Matricula.cargarTabla();
            //encontroCurso=false;
            frm_Matricula.estadoInicial();
            frm_Matricula.limpiarCurso(); 
            
            
        }
        if(e.getActionCommand().equals("Finalizar"))
        {  
            for(int contador=0;contador<frm_Matricula.getCantidadDeCursosMatriculados();contador++)
            {
                conexion.registrarMatricula(frm_Matricula.getInformacionTabla(contador));
                metodos.guardarEnXMLMatricula(frm_Matricula.getInformacionTabla(contador));
            }
            frm_Matricula.resetearInterfaz();
            //conexion.devolverCodigo();
            metodos.colocarCodigo();
            
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
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    public String colocarCodigo()
    {
        return metodos.colocarCodigo();
        //return conexion.devolverCodigo();
    }
}
