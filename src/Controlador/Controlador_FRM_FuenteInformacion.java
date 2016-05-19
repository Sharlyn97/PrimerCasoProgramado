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
    
    
     int numeroFuente=0;
    
    FRM_FuenteInformacion informacion;
    Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal;
    
    public Controlador_FRM_FuenteInformacion(FRM_FuenteInformacion informacion, Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal)
    {
        this.informacion=informacion;
        this.controlador_FRM_MenuPrincipal=controlador_FRM_MenuPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getActionCommand().equals("Confirmar"))
        {
            if( (informacion.getSeleccionArchivos()&&informacion.getSeleccionBaseDatos()&&informacion.getSeleccionXML()) || (informacion.getSeleccionArchivos()&&informacion.getSeleccionBaseDatos()) || (informacion.getSeleccionArchivos()&&informacion.getSeleccionXML()) || (informacion.getSeleccionBaseDatos()&&informacion.getSeleccionXML()) )
            {
                informacion.mensaje("Seleccione solo una fuente de informacion");
            } 
            else
             {
                  if(informacion.getSeleccionArchivos())
                  {
                      informacion.setVisible(false);
                      numeroFuente=1;
                   
                  }
                if(informacion.getSeleccionBaseDatos())
                {
                    informacion.setVisible(false);
                    numeroFuente=2;
                  
                }
                if (informacion.getSeleccionXML())
                 {
                     informacion.setVisible(false);
                     numeroFuente=3;
                   
                 } 
              }
          }
        controlador_FRM_MenuPrincipal.setFuente(numeroFuente);
        }
            
            
        
    
    public int devolverNumero()
    { 
        return this.numeroFuente;
    }
}
