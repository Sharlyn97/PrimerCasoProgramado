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
public class GUI_InformacionLogin extends javax.swing.JPanel {

    /**
     * Creates new form GUI_InformacionLogin
     */
    public GUI_InformacionLogin() {
        initComponents();
    }

     public String[] devolverInformacion()
    {
        String arreglo[];
        arreglo=new String[2];
        arreglo[0]=this.jt_NombreUsuario.getText();
        arreglo[1]=this.jpf_Contraseña.getText();
        
        return arreglo;
    }
     
     public String devolverNombre()
     {
         return this.jt_NombreUsuario.getText();
     }
     
     public String devolverContraseña()
     {
         return this.jpf_Contraseña.getText();
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jl_Usuario = new javax.swing.JLabel();
        jl_Contraseña = new javax.swing.JLabel();
        jt_NombreUsuario = new javax.swing.JTextField();
        jpf_Contraseña = new javax.swing.JPasswordField();

        jl_Usuario.setText("Nombre Usuario");

        jl_Contraseña.setText("Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jl_Usuario)
                    .addComponent(jl_Contraseña))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jpf_Contraseña))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Usuario)
                    .addComponent(jt_NombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_Contraseña)
                    .addComponent(jpf_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jl_Contraseña;
    private javax.swing.JLabel jl_Usuario;
    private javax.swing.JPasswordField jpf_Contraseña;
    private javax.swing.JTextField jt_NombreUsuario;
    // End of variables declaration//GEN-END:variables
}
