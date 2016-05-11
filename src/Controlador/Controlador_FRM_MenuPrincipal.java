/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;




import Modelo.ConexionBD;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import Vista.FRM_MantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * 
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener{
    
   
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_Matricula matricula;
    FRM_MantenimientoUsuarios frm_MantenimientoUsuarios;
    FRM_Login login;
    ConexionBD conexion;


    
    public Controlador_FRM_MenuPrincipal()
    {
        mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes();
        mantenimientoCursos=new FRM_MantenimientoCursos();
        matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos);
        frm_MantenimientoUsuarios= new  FRM_MantenimientoUsuarios();
        login=new FRM_Login();
        conexion=new ConexionBD();        
        mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.conexion=this.conexion;
        mantenimientoCursos.controlador.conexion=this.conexion;
        matricula.controlador.conexion=this.conexion;
        frm_MantenimientoUsuarios.usuarios.conexion=this.conexion;
        login.login.conexion=this.conexion;
       if(conexion.comprobarUsuario())
        {
           this.login.setVisible(true);
        }
       else
        {
            JOptionPane.showMessageDialog(null,"No hay usuarios registrados, favor dirigirse al modulo de usuarios");
        }
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            this.mantenimientoEstudiantes.setVisible(true);
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            this.mantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            this.matricula.setVisible(true);
            this.matricula.colocarCodigo();
        }
         if(e.getActionCommand().equals("Usuarios"))
        {
            this.frm_MantenimientoUsuarios.setVisible(true);
        }
    
    }
    
}