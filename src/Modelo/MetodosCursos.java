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
 * @author tecnologiamultimedia
 */
public class MetodosCursos {
    
    private ArrayList <Cursos> arrayCursos;
    String arregloInformacionConsultada[]=new String[3];
    int vueltasRegistrar=0;
    String arregloDatos[];
    
    public MetodosCursos()
    {
        arrayCursos=new ArrayList <Cursos>();
        arregloDatos=new String[3];
    }
   public boolean agregarCurso(String informacion[])//String siglasCurso
 {
     boolean cursoRepetido=false;
     boolean agrego=false;
     Cursos temporal=new Cursos(informacion[0], informacion[1], Integer.parseInt(informacion[2]), informacion[3]);
     
     if(vueltasRegistrar==0)
     {
        arrayCursos.add(temporal);
        vueltasRegistrar=1;
        agrego=true;
     }
     else
     {
         for(int contador=0; contador<arrayCursos.size(); contador++)
         {
            //System.out.println("Siglas contador: "+arrayCursos.get(contador).getSigla()+" 2.siglas usuario: "+informacion[1]);
           if(arrayCursos.get(contador).getSigla().equals(informacion[0]))  
           {
               cursoRepetido=true;
           }

         }
      if(cursoRepetido)
        {
                    //JOptionPane.showMessageDialog(null,"Yo estoy diciendo que ya existe :p"); 
         }
      else
        {
                    arrayCursos.add(temporal);
                    cursoRepetido=false;
                    agrego=true;
        }
     }     
     return agrego;
 }

 public boolean modificarCurso(String informacion[])//revisar creditos[]
 {
     boolean modifico=false;
     
     for(int contador=0; contador<arrayCursos.size(); contador++)
     {
         if(arrayCursos.get(contador).getSigla().equals(informacion[0]))
         {
             arrayCursos.get(contador).setNombre(informacion[1]);
             arrayCursos.get(contador).setCreditos(Integer.parseInt(informacion[2]));
             arrayCursos.get(contador).setHorario(informacion[3]);
             modifico=true;
         }
        // System.out.println("Siglas contador: "+arrayCurso.get(contador).getSiglas()+" 2.siglas usuario: "+informacion[1]);
     }
     return modifico;
 }
 
 public boolean consultarCurso(String siglasCurso) 
 {
     boolean consulto=false;
     for(int contador=0; contador<arrayCursos.size(); contador++)
     {
         //System.out.println(arrayCurso.get(contador).getNombre());
         if(arrayCursos.get(contador).getSigla().equals(siglasCurso))
        {
            arregloDatos[0]=arrayCursos.get(contador).getNombre();
            arregloDatos[1]=""+arrayCursos.get(contador).getCreditos();
            arregloDatos[2]=arrayCursos.get(contador).getHorario();
            consulto=true;
        }
     }
     
    return consulto;
 }
 
 public boolean  eliminarCurso(String siglasCurso)
 {
     int vueltas=0;
     boolean eliminado=false;
     for(int contador=0; contador<arrayCursos.size(); contador++)
     {
         if(arrayCursos.get(contador).getSigla().equals(siglasCurso))
         {
             arrayCursos.remove(contador);
             eliminado=true;
             //JOptionPane.showMessageDialog(null,"El curso se ha eliminado correctamente");
         }
         else
         {
             vueltas++;
             if(vueltas==arrayCursos.size())
             {
               // JOptionPane.showMessageDialog(null,"El curso no existe");   
             }
         }
     }
     return eliminado;
 }
 public void mostrarInformacion()
 {
      Cursos temporal;
     temporal=arrayCursos.get(0);
     //System.out.println(temporal.getInformacion());
 }
 
 public String[] getArregloInformacion()
    {
        return this.arregloDatos;
    }
    
}
