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
 * @author Jesse
 */
public class MetodosEstudiantes {
    
    private  ArrayList <Estudiante> arrayEstudiantes;
    String arregloInformacionConsultada[]=new String[2];
    int vueltasRegistrar=0;
    Estudiante  archivoEstudiante;
    
    public MetodosEstudiantes()
    {
        arrayEstudiantes=new ArrayList <Estudiante>();
    }
    
    
    
    public boolean agregarEstudiante(String informacion[], String cedula)
    {
          boolean estudianteRepetido=false;
          boolean agrego=false;
    Estudiante temporal=new Estudiante(informacion[0], informacion[1], informacion[2]);
    
    if(vueltasRegistrar==0)
    {  
      arrayEstudiantes.add(temporal);
      vueltasRegistrar=1;
     
     // JOptionPane.showMessageDialog(null,"El estudiante se agregó correctamente");  
     agrego=true;
    }    
    else
    { 
      for(int contador=0; contador<arrayEstudiantes.size(); contador++)
        { 
          if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                estudianteRepetido=true;  
            }     
         }   
           if(estudianteRepetido)
            {
                    //JOptionPane.showMessageDialog(null,"El estudiante ya existe"); 
            }
           else
            {
                    arrayEstudiantes.add(temporal);
                    //JOptionPane.showMessageDialog(null,"El estudiante se agregó correctamente");
                    
                    estudianteRepetido=false;
                    agrego=true;
             }
    }
        return agrego;
    }
    
    public ArrayList <Estudiante> getArray()
    {
        System.out.println("Array: "+arrayEstudiantes.get(0).getInformacion());
        return arrayEstudiantes;
    }
    public void setArray(ArrayList<Estudiante>array)
    {
      arrayEstudiantes=array;
    }
    
    public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            System.out.println(arrayEstudiantes.get(contador).getInformacion());
        
        }
    
    }
    public boolean consultarEstudiante(String cedula)
    {
        boolean existe=false;
        
        for(int contador=0;contador<arrayEstudiantes.size();contador++)
        {
            if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
            {
                arregloInformacionConsultada[0]=arrayEstudiantes.get(contador).getNombreCompleto();
                arregloInformacionConsultada[1]=arrayEstudiantes.get(contador).getDireccion();
                existe=true;
            }
        
        }
        return existe;
    
    }
    public boolean modificarEstudiante(String cedula, String nombre, String direccion)
    { 
        boolean modifico=false;
        int vueltas=0;
     for(int contador=0; contador<arrayEstudiantes.size(); contador++)
     {
         if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
         {
             arrayEstudiantes.get(contador).setNombreCompleto(nombre);
             arrayEstudiantes.get(contador).setDireccion(direccion);
             modifico=true;
            // JOptionPane.showMessageDialog(null,"El estudiante se modificó correctamente"); 
         }
         else
         {
             vueltas++;
             if(vueltas==arrayEstudiantes.size())
             {
              //JOptionPane.showMessageDialog(null,"El estudiante no existe"); 
             }
         }
     }
     return modifico;
    }
    public boolean eliminarEstudiante(String cedula)
    {
        boolean elimino=false;
        int vueltas=0;
     for(int contador=0; contador<arrayEstudiantes.size(); contador++)
     {
         if(arrayEstudiantes.get(contador).getCedula().equals(cedula))
         {
             arrayEstudiantes.remove(contador);
             elimino=true;
            // JOptionPane.showMessageDialog(null,"El estudiante se ha eliminado correctamente");   
         }
     }
     return  elimino;
    }
   
    public String[] getArregloInformacion()
    {
        
        return this.arregloInformacionConsultada;
        
    }    
  
}
