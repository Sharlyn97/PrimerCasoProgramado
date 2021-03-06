/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesse Fabian
 */
public class MetodosUsuarios {
    
    private ArrayList <Usuario> arrayUsuarios;
    String arregloInformacionConsultada[];
    
    public MetodosUsuarios()
    {
        arrayUsuarios=new ArrayList <Usuario>();
        arregloInformacionConsultada=new String[3];
    }
     public ArrayList <Usuario> getArray()
    {
        //System.out.println("Array: "+arrayUsuarios.get(0).getInformacion());
        return arrayUsuarios;
    }
    public void setArray(ArrayList<Usuario>array)
    {
      arrayUsuarios=array;
    }
    
    public boolean agregarUsuario(String informacion[])
    {
        Usuario temporal=new Usuario(informacion[0],informacion[1],informacion[2]);  
        arrayUsuarios.add(temporal);
        return true;
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            System.out.println(arrayUsuarios.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarUsuario(String nombreUsuario)
    {
        boolean existe=false;
        System.out.println("nombreEntrante: "+nombreUsuario);
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            System.out.println("usuarios gurdados: "+arrayUsuarios.get(contador).getNombreUsuario());
            
            
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(nombreUsuario))
            {
                arregloInformacionConsultada[0]=arrayUsuarios.get(contador).getNombre();
                arregloInformacionConsultada[1]=arrayUsuarios.get(contador).getNombreUsuario();

                existe=true;
            }
        
        }
        
        return existe;
    }
    
    public boolean consultarLoginUsuario(String nombreUsuario,String contraseña)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(nombreUsuario) && arrayUsuarios.get(contador).getContraseña().equals(contraseña))
            {
                existe=true;
            }
        
        }
        return existe;
    
    }
    
    
    public boolean modificarUsuario(String arreglo[])
    {
        boolean modifico=false;
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[1]))
            {
                arrayUsuarios.get(contador).setNombre(arreglo[0]);
                arrayUsuarios.get(contador).setNombreUsuario(arreglo[1]);
                modifico=true;
            }
        }
        return modifico;
    }
    public boolean eliminarUsuario(String arreglo[])
    {
        boolean elimino=false;
        for(int contador=0;contador<arrayUsuarios.size();contador++)
        {
            if(arrayUsuarios.get(contador).getNombreUsuario().equals(arreglo[1]))
            {
                arrayUsuarios.remove(contador);
                elimino=true;
            }
        }
        return elimino;
    }
    
    
    public void mensaje(String mensaje)
    {
       JOptionPane.showMessageDialog(null,mensaje);
    }
    
    public String[] getArregloInformacion()
    {
        return this.arregloInformacionConsultada;
    }
    
    public boolean comprobarUsuario()
    {
        boolean usuario=false;
        
        if(arrayUsuarios.size()>=1)
        {
            usuario=true;
        }
        
        
        return usuario; 
    }
}
