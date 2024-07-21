/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/**
 *
 * @author layla
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     * @throws java.sql.SQLException
     */
    public Login() throws SQLException {
        this.con = conexao.connection();
        initComponents();
  
    } Conexao conexao = new Conexao();
             Connection con;
        ResultSet rs;
        PreparedStatement pst;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfLogin = new javax.swing.JTextField();
        jlLogin = new javax.swing.JLabel();
        pfSenha = new javax.swing.JPasswordField();
        jlSenha = new javax.swing.JLabel();
        btnLogar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela de Login");
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfLogin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 139, 30));

        jlLogin.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jlLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlLogin.setText("Login");
        jlLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 146, 100, 30));

        pfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pfSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(pfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 139, 30));

        jlSenha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jlSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlSenha.setText("Senha");
        jlSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jlSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 30));

        btnLogar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnLogar.setText("Logar");
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2botaoSair(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 470, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(833, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed
        try {
            pst = con.prepareStatement("select login, senha from Usuario where login =? and senha =?");
            pst.setString(1, tfLogin.getText());
            pst.setString(2, new String(pfSenha.getPassword()));
            rs = pst.executeQuery();
           if (rs.next()) { 
            Menu menu = new Menu();
            menu.setVisible(true);
            this.dispose();
}

        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Uusario Não encontrado");
        }
    }//GEN-LAST:event_btnLogarActionPerformed

    private void jButton2botaoSair(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2botaoSair
        this.dispose();
    }//GEN-LAST:event_jButton2botaoSair

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new Login().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlLogin;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JPasswordField pfSenha;
    private javax.swing.JTextField tfLogin;
    // End of variables declaration//GEN-END:variables
}
