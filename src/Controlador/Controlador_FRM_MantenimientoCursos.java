/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import Modelo.ConexionBD;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    ConexionBD conexion;
    
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos= frm_MantenimientoCursos;
        this.conexion=conexion;
        frm_MantenimientoCursos.estadoInicial();
    } 
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
         conexion.registrarCurso(frm_MantenimientoCursos.devolverSigla(),frm_MantenimientoCursos.devolverNombre(),frm_MantenimientoCursos.devolverCreditos(),frm_MantenimientoCursos.devolverHorario());
         frm_MantenimientoCursos.resetearInterfaz();
         frm_MantenimientoCursos.estadoInicial();
         frm_MantenimientoCursos.habilitarTF();
        }
        if(e.getActionCommand().equals("Consultar"))
        {
          if(conexion.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
          {
           frm_MantenimientoCursos.mostrarInformacion(conexion.retornarCursos());
           frm_MantenimientoCursos.habilitarBotones();
           frm_MantenimientoCursos.deshabilitarTF();
          }
          else
          {
              mensaje("El curso no sido registrado");
              frm_MantenimientoCursos.habilitarBotones();
          }
        }
        if(e.getActionCommand().equals("Modificar"))
        {
            conexion.actualizarCursos(frm_MantenimientoCursos.devolverSigla(),frm_MantenimientoCursos.devolverNombre(),frm_MantenimientoCursos.devolverCreditos(),frm_MantenimientoCursos.devolverHorario());
            mensaje("El estudiante se modificó exitosamente");
            frm_MantenimientoCursos.resetearInterfaz();
            frm_MantenimientoCursos.estadoInicial();
            frm_MantenimientoCursos.habilitarTF();
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            conexion.eliminarCurso(frm_MantenimientoCursos.devolverSigla());
            mensaje("El estudiante ha sido eliminado exitosamente");
            frm_MantenimientoCursos.resetearInterfaz();
            frm_MantenimientoCursos.estadoInicial();
            frm_MantenimientoCursos.habilitarTF();
        }
    }
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
}
