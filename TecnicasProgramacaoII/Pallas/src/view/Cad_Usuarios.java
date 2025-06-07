package view;

import DAO.ConnectDAO;
import classes.Usuario;
import java.util.Arrays;

public class Cad_Usuarios extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "Nenhum";
    
    public Cad_Usuarios() {
        initComponents();
    }
    
    public Cad_Usuarios(String operacaoAtiva) {
       initComponents();
       operacaoAtivaGlobal = operacaoAtiva;
       String operacao = "Incluir";
       
       if(operacaoAtiva.equals(operacao)) {
            nomeLabel.setVisible(true);
            senhaLabel.setVisible(true);
            senha2Label.setVisible(true);
            emailLabel.setVisible(true);
            nomeField.setVisible(true);
            senhaField.setVisible(true);
            senha2Field.setVisible(true);
            emailField.setVisible(true);
            cadastrarButton.setText("Incluir BD");
       }
       
    }
    
    Usuario tela_usu = new Usuario();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        senhaLabel = new javax.swing.JLabel();
        senha2Label = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        limparTelaButton = new javax.swing.JButton();
        cadastrarButton = new javax.swing.JButton();
        senhaField = new javax.swing.JPasswordField();
        LerButton = new javax.swing.JButton();
        emailLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        senha2Field = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nomeLabel.setText("Nome:");

        senhaLabel.setText("Senha:");

        senha2Label.setText("Confirme sua senha:");

        limparTelaButton.setText("Limpar tela");
        limparTelaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparTelaButtonActionPerformed(evt);
            }
        });

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        LerButton.setText("Ler");
        LerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LerButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("E-mail:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nomeField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(senha2Label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senha2Field, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(senhaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(senhaField))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(limparTelaButton)
                        .addGap(118, 118, 118)
                        .addComponent(LerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cadastrarButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaLabel)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senha2Label)
                    .addComponent(senha2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparTelaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(LerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cadastrarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparTelaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparTelaButtonActionPerformed
        // Limpar:
        emailField.setText("");
        nomeField.setText("");
        senhaField.setText("");
        senha2Field.setText("");
    }//GEN-LAST:event_limparTelaButtonActionPerformed

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        // Cadastrar:
        // INSERT NO DB:
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            tela_usu.setNome(nomeField.getText());
            tela_usu.setSenha(senhaField.getText());
            tela_usu.setEmail(emailField.getText());

            
            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("usuario", tela_usu.dadosSQLValues());
            
            nomeField.setText("");
            senhaField.setText("");
            emailField.setText("");
            senha2Field.setText("");
        }
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void LerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LerButtonActionPerformed
        // Ler:

    }//GEN-LAST:event_LerButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LerButton;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JButton limparTelaButton;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JPasswordField senha2Field;
    private javax.swing.JLabel senha2Label;
    private javax.swing.JPasswordField senhaField;
    private javax.swing.JLabel senhaLabel;
    // End of variables declaration//GEN-END:variables
}
