/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_MantenimientoEstudiantes;


/**
 *
 * 
 */
public class FRM_MantenimientoEstudiantes extends javax.swing.JFrame {
    

    public Controlador_FRM_MantenimientoEstudiantes controlador_FRM_MantenimientoEstudiantes;
    
    public FRM_MantenimientoEstudiantes() {
        initComponents();
        setVisible(false);
        controlador_FRM_MantenimientoEstudiantes=new Controlador_FRM_MantenimientoEstudiantes(this);
        gUI_Botones1.agregarEventos(controlador_FRM_MantenimientoEstudiantes);
    }
    public String[] devolverInformacion()
    {
        return this.gUI_InformacionEstudiantes1.devolverInformacion();
    }
    public void estadoInicial()
    {
        this.gUI_Botones1.estadoInicial();
    }
    public boolean checar()
    {
        return this.gUI_InformacionEstudiantes1.checarEstado();
    }
    
    public void habilitarAgregar()
    {
        this.gUI_Botones1.habilitarAgregar();
    }
    public void habilitarBotones()
    {
        this.gUI_Botones1.habilitarBotones();
    }
    public String devolverCedula()
    {
        return this.gUI_InformacionEstudiantes1.devolverCedula();
    }
    
    public String devolverNombre()
    {
        return this.gUI_InformacionEstudiantes1.devolverNombre();
    }
    
    public String devolverDireccion()
    {
        return this.gUI_InformacionEstudiantes1.devolverDireccion();
    }
    
    public void resetearInterfaz()
    {
        this.gUI_InformacionEstudiantes1.resetearInterfaz();
    }
    
    public void mostrarInformacion(String arreglo[])
    {
        this.gUI_InformacionEstudiantes1.mostrarInformacion(arreglo);
    }
    
    public void deshabilitarTF()
    {
        this.gUI_InformacionEstudiantes1.deshabilitarTF();
    }
    
    public void habilitarTF()
    {
        this.gUI_InformacionEstudiantes1.habilitarTF();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gUI_Botones1 = new Vista.GUI_Botones();
        gUI_InformacionEstudiantes1 = new Vista.GUI_InformacionEstudiantes();

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gUI_InformacionEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gUI_InformacionEstudiantes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gUI_Botones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentHidden
     //   controlador_FRM_MantenimientoEstudiantes.crearElArchivo();
    }//GEN-LAST:event_formComponentHidden

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Vista.GUI_Botones gUI_Botones1;
    private Vista.GUI_InformacionEstudiantes gUI_InformacionEstudiantes1;
    // End of variables declaration//GEN-END:variables
}
