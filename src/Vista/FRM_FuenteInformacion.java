/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author Jesse Fabian
 */
public class FRM_FuenteInformacion extends javax.swing.JFrame {

    /**
     * Creates new form FRM_FuenteInformacion
     */
    public FRM_FuenteInformacion() {
        initComponents();
    }

    
    public void getSeleccion()
    {
        this.jrb_Archivos.isSelected();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jrb_Archivos.setText("Archivos Planos");

        jrb_BaseDatos.setText("Base de Datos");

        jrb_XML.setText("XML");

        btn_Confirmar.setText("Confirmar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jrb_BaseDatos)
                    .addComponent(jrb_Archivos)
                    .addComponent(jrb_XML))
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_Confirmar)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jrb_Archivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrb_BaseDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jrb_XML)
                .addGap(24, 24, 24)
                .addComponent(btn_Confirmar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Confirmar;
    private javax.swing.JRadioButton jrb_Archivos;
    private javax.swing.JRadioButton jrb_BaseDatos;
    private javax.swing.JRadioButton jrb_XML;
    // End of variables declaration//GEN-END:variables
}