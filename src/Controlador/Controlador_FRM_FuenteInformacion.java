/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.FRM_FuenteInformacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Moon
 */
public class Controlador_FRM_FuenteInformacion implements ActionListener{
    
    public int numero;
    
    FRM_FuenteInformacion informacion;
    
    
    public Controlador_FRM_FuenteInformacion(FRM_FuenteInformacion informacion)
    {
        this.informacion=informacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("Confirmar"))
        {
            if(informacion.getSeleccionArchivos()&&informacion.getSeleccionBaseDatos()&&informacion.getSeleccionXML())
            {
                System.out.println("Seleccione solo un archivo");
            }
            else
            {
                if(informacion.getSeleccionArchivos())
                {
                 System.out.println("Selecciono archivos");
                }
                else
                {
                    if(informacion.getSeleccionBaseDatos())
                    {
                     System.out.println("Selecciono Base de datos");
                    }
                    else
                    {
                      if (informacion.getSeleccionXML())
                        {
                          System.out.println("Selecciono XML");
                        }
                    }
                }
            }
          
        }
        
        
        
    }
    
}
