/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador_FRM_Login;

/**
 *
 * @author Jesse Fabian
 */
public class GUI_BotonesLogin extends javax.swing.JPanel {

    /**
     * Creates new form GUI_BotonesLogin
     */
    
    Controlador_FRM_Login controladorLogin;
    
    public GUI_BotonesLogin() {
        initComponents();
    }

    public void agregarEventos(Controlador_FRM_Login controlador)
    {
        this.controladorLogin=controlador;
        this.btn_Entrar.addActionListener(controlador);
        this.btn_Salir.addActionListener(controlador);
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Entrar = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();

        btn_Entrar.setText("Entrar");

        btn_Salir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Entrar)
                .addGap(18, 18, 18)
                .addComponent(btn_Salir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Entrar)
                    .addComponent(btn_Salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Entrar;
    private javax.swing.JButton btn_Salir;
    // End of variables declaration//GEN-END:variables
}
