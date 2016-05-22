/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_MantenimientoUsuarios;
import javax.swing.JOptionPane;

/**
 *
 * @author Jesse Fabian
 */
public class FRM_MantenimientoUsuarios extends javax.swing.JFrame {
FRM_Login login;///
    
    public Controlador_FRM_MantenimientoUsuarios usuarios;
    public FRM_MantenimientoUsuarios(FRM_MenuPrincipal menu,FRM_Login login) {///
        initComponents();
        this.login=login;///
        setVisible(false);
        usuarios= new Controlador_FRM_MantenimientoUsuarios(this,login);
        gUI_Botones1.agregarEventos(usuarios);
    }
    public String devolverNombreUsuario()
    {
        
        return this.gUI_InformacionUsuarios1.devolverNombreDeUsuario();
    }
    
    public String[] devolverInformacion()
    {
        return this.gUI_InformacionUsuarios1.devolverInformacion();
    }
    
    public void mostrarInformacion(String arreglo[])
    {
         this.gUI_InformacionUsuarios1.mostrarInformacion(arreglo);
    }

     public void mostrarInformacionXML(String arreglo[])
    {
         this.gUI_InformacionUsuarios1.mostrarInformacionXML(arreglo);
    }
    
    public void habilitarBotones()
    {
        this.gUI_Botones1.habilitarBotones();
    }
    
    public void resetearIntefaz()
    {
        this.gUI_InformacionUsuarios1.resetearInterfaz();
    }
    
    public String devolverNombreCompleto()
    {
        return this.gUI_InformacionUsuarios1.devolverNombreCompleto();
    }
    
    public String devolverContraseña()
    {
        return this.gUI_InformacionUsuarios1.devolverContraseña();
    }
    
    public String devolverTipo()
    {
        return this.gUI_InformacionUsuarios1.devolverTipo();
    }
    public void deshabilitarTF()
    {
        this.gUI_InformacionUsuarios1.deshabilitarTF();
    }
    public void habilitarTF()
    {
        this.gUI_InformacionUsuarios1.habilitarTF();
    }
    public void estadoInicial()
    {
        this.gUI_Botones1.estadoInicial();
    }

    public void resetearInterfaz()
    {
        this.gUI_InformacionUsuarios1.resetearInterfaz();
    }
    public void mensaje(String mensaje)
    {
        JOptionPane.showMessageDialog(null,mensaje);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_InformacionUsuarios1 = new Vista.GUI_InformacionUsuarios();
        gUI_Botones1 = new Vista.GUI_Botones();

        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gUI_InformacionUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_InformacionUsuarios1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden

        usuarios.crearArchivo();
        System.out.println("creo el archivo");
    }//GEN-LAST:event_formComponentHidden

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private Vista.GUI_InformacionUsuarios gUI_InformacionUsuarios1;
    // End of variables declaration//GEN-END:variables
}
