/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_FuenteInformacion;
import Controlador.Controlador_FRM_MenuPrincipal;

/**
 *
 * @author Jesse Fabian
 */
public class FRM_FuenteInformacion extends javax.swing.JFrame {

    /**
     * Creates new form FRM_FuenteInformacion
     */
    public Controlador_FRM_FuenteInformacion controlador;
    
    
    public FRM_FuenteInformacion(Controlador_FRM_MenuPrincipal controlador_FRM_MenuPrincipal) {
        initComponents();
        controlador=new Controlador_FRM_FuenteInformacion(this,controlador_FRM_MenuPrincipal);
        agregarEventos();
    }

     public void agregarEventos()
    {
        this.btn_Confirmar.addActionListener(controlador);
        this.jrb_Archivos.addActionListener(controlador);
        this.jrb_BaseDatos.addActionListener(controlador);
        this.jrb_XML.addActionListener(controlador);
    }
    
    public boolean getSeleccionArchivos()
    {
      return  this.jrb_Archivos.isSelected();
    }
    public boolean getSeleccionBaseDatos()
    {
      return   this.jrb_BaseDatos.isSelected();
    }
    public boolean getSeleccionXML()
    {
     return   this.jrb_XML.isSelected();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jrb_Archivos = new javax.swing.JRadioButton();
        jrb_BaseDatos = new javax.swing.JRadioButton();
        jrb_XML = new javax.swing.JRadioButton();
        btn_Confirmar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setResizable(false);

        jrb_Archivos.setText("Archivos Planos");

        jrb_BaseDatos.setText("Base de Datos");

        jrb_XML.setText("XML");

        btn_Confirmar.setText("Confirmar");

        jLabel1.setText("Indique la fuente de información que desea utilizar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrb_BaseDatos)
                            .addComponent(jrb_Archivos)
                            .addComponent(jrb_XML)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(btn_Confirmar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jrb_Archivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrb_BaseDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrb_XML)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Confirmar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jrb_Archivos;
    private javax.swing.JRadioButton jrb_BaseDatos;
    private javax.swing.JRadioButton jrb_XML;
    // End of variables declaration//GEN-END:variables
}
