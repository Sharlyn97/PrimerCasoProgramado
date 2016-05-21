/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Jesse Fabian
 */
public class GUI_InformacionUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form GUI_InformacionUsuarios
     */
    public GUI_InformacionUsuarios() {
        initComponents();
    }

    public String[] devolverInformacion()// este metodo devuelve la informacion de los jt
    {
        String arreglo[];
        arreglo= new String[4];// hay que poner la cantidad sino da error 
         
        arreglo[0]=this.jt_NombreCompleto.getText();// esto hace que me muestre la informacion que se pone en los jt
        arreglo[1]=this.jt_NombreUsuario.getText();
        arreglo[2]= this.jpf_Contraseña.getText();
        arreglo[3]= ""+this.jcb_Tipo.getSelectedIndex();// este trae la informacion del combo box 
        
        return arreglo;
    }

 public String devolverNombreCompleto()
 {
     return this.jt_NombreCompleto.getText();
 }
 public String devolverNombreDeUsuario()
 {
     
     return this.jt_NombreUsuario.getText();// muestra el nombre de usuario  que se escribe
 }
 public String devolverContraseña()
 {
     return this.jpf_Contraseña.getText();
 }
 
 public String devolverTipo()
 {
     return this.jcb_Tipo.getToolTipText();
 }
 
 public void mensaje(String mensaje)
 {
     JOptionPane.showMessageDialog(null,mensaje);
 }
 
 public void mostrarInformacion(String arreglo[])
 {
     this.jt_NombreCompleto.setText(arreglo[0]);
     this.jpf_Contraseña.setText(arreglo[1]);
//     this.jcb_Tipo.setSelectedIndex(Integer.parseInt(arreglo[2]));
 }
 
 public void resetearInterfaz()
 {
     this.jt_NombreCompleto.setText("");
     this.jt_NombreUsuario.setText("");
     this.jpf_Contraseña.setText("");
 }
 
 public void deshabilitarTF()
 {
     this.jt_NombreUsuario.setEnabled(false);
 }
 public void habilitarTF()
 {
     this.jt_NombreUsuario.setEnabled(true);
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Nombre = new javax.swing.JLabel();
        jl_Usuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jl_Tipo = new javax.swing.JLabel();
        jt_NombreCompleto = new javax.swing.JTextField();
        jt_NombreUsuario = new javax.swing.JTextField();
        jpf_Contraseña = new javax.swing.JPasswordField();
        jcb_Tipo = new javax.swing.JComboBox();

        jl_Nombre.setText("Nombre Completo");

        jl_Usuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        jl_Tipo.setText("Tipo");

        jcb_Tipo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "usuario", "administrador", " " }));
        jcb_Tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcb_TipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Usuario)
                    .addComponent(jl_Contraseña)
                    .addComponent(jl_Tipo)
                    .addComponent(jl_Nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 78, Short.MAX_VALUE))
                    .addComponent(jt_NombreCompleto)
                    .addComponent(jt_NombreUsuario)
                    .addComponent(jpf_Contraseña))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Usuario))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jt_NombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_Nombre))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contraseña)
                    .addComponent(jpf_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Tipo)
                    .addComponent(jcb_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcb_TipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcb_TipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcb_TipoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcb_Tipo;
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_Nombre;
    private javax.swing.JLabel jl_Tipo;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jpf_Contraseña;
    private javax.swing.JTextField jt_NombreCompleto;
    private javax.swing.JTextField jt_NombreUsuario;
    // End of variables declaration//GEN-END:variables
}
