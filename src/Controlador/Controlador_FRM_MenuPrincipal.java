/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;




import Modelo.ConexionBD;
import Modelo.Metodos_XML;
import Vista.FRM_FuenteInformacion;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import Vista.FRM_MantenimientoUsuarios;
import Vista.FRM_MenuPrincipal;
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
    Metodos_XML metodos;
    FRM_FuenteInformacion informacion;
    Controlador_FRM_FuenteInformacion controladorInformacion;
    FRM_MenuPrincipal menu;
    int fuente=0;
    
    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal menu)
    {
        
            this.menu=menu;
        
            informacion=new FRM_FuenteInformacion(this);        
            
            mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes();
            mantenimientoCursos=new FRM_MantenimientoCursos();
            frm_MantenimientoUsuarios= new  FRM_MantenimientoUsuarios(menu); 
            login=new FRM_Login(menu);
            conexion=new ConexionBD(); 
            metodos=new Metodos_XML();
            matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos);
            matricula.controlador.metodosEstudiantes=mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodosEstudiantes;
            matricula.controlador.metodosCursos=mantenimientoCursos.controlador.metodosCursos;    
            login.login.archivo=frm_MantenimientoUsuarios.usuarios.archivo;
            this.informacion.setVisible(true);            
            
    
                        
            mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.conexion=this.conexion;
            mantenimientoCursos.controlador.conexion=this.conexion;
            matricula.controlador.conexion=this.conexion;
            frm_MantenimientoUsuarios.usuarios.conexion=this.conexion;
            login.login.conexion=this.conexion;
           
            mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.metodos=this.metodos;
            mantenimientoCursos.controlador.metodos=this.metodos;
            matricula.controlador.metodos=this.metodos;
            frm_MantenimientoUsuarios.usuarios.metodos=this.metodos;
            login.login.metodos=this.metodos;
           
        
    }
    public void setFuente(int fuente)
    {
        mantenimientoEstudiantes.controlador_FRM_MantenimientoEstudiantes.setFuente(fuente);
        mantenimientoCursos.controlador.setFuente(fuente);
        frm_MantenimientoUsuarios.usuarios.setFuente(fuente);
        matricula.controlador.setFuente(fuente); 
        login.login.setFuente(fuente);
        this.fuente=fuente;   
       
        if(fuente==1)
        {
       if(frm_MantenimientoUsuarios.usuarios.metodosUsuarios.comprobarUsuario())
       {
            this.login.setVisible(true);
            //this.menu.setVisible(true);
            }
           else
            {
                JOptionPane.showMessageDialog(null,"No hay usuarios registrados, favor dirigirse al modulo de usuarios");
                this.frm_MantenimientoUsuarios.setVisible(true);
            }         
        }
        if(fuente==2)
        {
           if(conexion.comprobarUsuario())
            {
               this.login.setVisible(true);
            }
           else
            {
                JOptionPane.showMessageDialog(null,"No hay usuarios registrados, favor dirigirse al modulo de usuarios");
                this.frm_MantenimientoUsuarios.setVisible(true);
            }
        }
        if(fuente==3)
        {
         if(metodos.comprobarUsuarios())
        {
           this.login.setVisible(false);
            }
           else
            {
                JOptionPane.showMessageDialog(null,"No hay usuarios registrados, favor dirigirse al modulo de usuarios");
               this.menu.setVisible(true);
               //this.frm_MantenimientoUsuarios.setVisible(true);
            } 
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
            if(fuente==1)
            {
            this.matricula.colocarCodigoArchivos();
            }
            if(fuente==2)
            {
            this.matricula.colocarCodigoBaseDatos();
            }
            if(fuente==3)
            {
            this.matricula.colocarCodigoXML();
            }
        }
         if(e.getActionCommand().equals("Usuarios"))
        {
            this.frm_MantenimientoUsuarios.setVisible(true);
        }
    
    }
    
}
