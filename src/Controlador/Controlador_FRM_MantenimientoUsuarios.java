
package Controlador;

import Modelo.ConexionBD;
import Vista.FRM_MantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

// afopsdmgfdmgodhbdkflokdmgotrfsfoiffmdvpodfbodfzmc

public class Controlador_FRM_MantenimientoUsuarios implements ActionListener{
    
FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
ConexionBD conexion;

    public Controlador_FRM_MantenimientoUsuarios(FRM_MantenimientoUsuarios frm_MantenimientoUsuarios) 
    {
        this.frm_MantenimientoUsuarios=frm_MantenimientoUsuarios;
        this.conexion=conexion;
    }

    
    public void actionPerformed(ActionEvent e) 
    {
            if(e.getActionCommand().equals("Agregar"))
            {   
           conexion.registrarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto(),frm_MantenimientoUsuarios.devolverNombreUsuario(),frm_MantenimientoUsuarios.devolverContraseña(),frm_MantenimientoUsuarios.devolverTipo());
           mensaje("El usuario ha sido agregado exitosamente");
           frm_MantenimientoUsuarios.resetearIntefaz();
           frm_MantenimientoUsuarios.estadoInicial();
           frm_MantenimientoUsuarios.habilitarTF();           
            }
            if(e.getActionCommand().equals("Modificar"))
            {
            conexion.actualizarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto(),frm_MantenimientoUsuarios.devolverNombreUsuario(),frm_MantenimientoUsuarios.devolverContraseña(),frm_MantenimientoUsuarios.devolverTipo());
            mensaje("El usuario se modificó exitosamente");
            frm_MantenimientoUsuarios.resetearIntefaz();
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.habilitarTF();
            }
            
            if(e.getActionCommand().equals("Consultar"))
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
            
          if(e.getActionCommand().equals("Eliminar"))
           {
            conexion.eliminarUsuario(frm_MantenimientoUsuarios.devolverNombreCompleto());
            mensaje("El usuario ha sido eliminado exitosamente");
            frm_MantenimientoUsuarios.resetearIntefaz();
            frm_MantenimientoUsuarios.estadoInicial();
            frm_MantenimientoUsuarios.habilitarTF();
           }

    }
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }    
}
