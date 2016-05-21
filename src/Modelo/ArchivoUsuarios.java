/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Jesse Fabian
 */
public class ArchivoUsuarios {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivoUsuarios()
    {
        if(cargarArchivoUsuarios()){
         System.out.println("El archivo usuarios se cargó correctamente");   
        }
        else
        {
          System.out.println("Error al cargar archivo usuarios"); 
          crearArchivoUsuarios();
        }
    }
    
     public void crearArchivoUsuarios()
            {
                try{       
                archivoSalida=new ObjectOutputStream(new FileOutputStream("archivoUsuarios.dat"));
                System.out.println("Se creó el archivo de usuarios de forma correcta");
                }
                catch(Exception e)
                {
                 System.out.println("Error al crear archivo de usuarios "+e);
                }

            }
     
     public boolean cargarArchivoUsuarios()
                {
                    boolean existe=false;
                    try{           

                    archivoEntrada=new ObjectInputStream(new FileInputStream("archivoUsuarios.dat"));
                    existe=true;
                    
                            }
                    catch(Exception e)
                    {
                        System.out.println("Error al cargar archivo usuarios "+e);
                    }
                    return existe;
                }
     public void ingresarInformacionUsuarios(Usuario usuario)
        {
         try
         {
             archivoSalida.writeObject(usuario);
             System.out.println("Se escribió de forma correcta la información del archivo");
         }
         catch(Exception e)
         {
             System.out.println("Error al ingresar información al archivo"+e);
         }
        }
     
      public ArrayList<Usuario> devolverInformacionDeUsuario()
        {
            ArrayList <Usuario> arrayUsuario=new ArrayList<Usuario>();
            
            try
            {
              while(true)
              {
                  arrayUsuario.add((Usuario)archivoEntrada.readObject());
              }
            }
            catch(Exception e)
            {
                System.out.println("Se llegó al final del archivo cursos");
            }
            
            return arrayUsuario;
        }
        
        
        
}
