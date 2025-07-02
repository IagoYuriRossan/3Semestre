package view;

import DAO.ConnectDAO;
import classes.Usuario;
import java.util.List;

public class Cad_Usuarios extends javax.swing.JFrame {

    String operacaoAtivaGlobal = "nenhum";
    
    public Cad_Usuarios() {
        initComponents();
    }
    
    public Cad_Usuarios(String operacaoAtiva) {
       initComponents();
       operacaoAtivaGlobal = operacaoAtiva;
       
       if(operacaoAtiva.equals("Incluir")) {
            this.setAllVisible(true);
            idField.setVisible(false);
            idLabel.setVisible(false);
       }
       
       if (operacaoAtiva.equals("Alterar") || operacaoAtiva.equals("Excluir") ) {
           this.setAllVisible(false);
           idField.setVisible(true);
           idLabel.setVisible(true);
           
           cadastrarButton.setVisible(true);
           cadastrarButton.setText("Pesquisar");
           
       }
       
       
       
    }
    
    private void setAllVisible(Boolean visible){
        usernameLabel.setVisible(visible);
        nomeLabel.setVisible(visible);
        senhaLabel.setVisible(visible);
        emailLabel.setVisible(visible);
        nomeField.setVisible(visible);
        usernameField.setVisible(visible);
        senhaField.setVisible(visible);
        emailField.setVisible(visible);
    }
    
    private void setAllEnabled(Boolean enabled){
        usernameLabel.setEnabled(enabled);
        nomeLabel.setEnabled(enabled);
        senhaLabel.setEnabled(enabled);
        emailLabel.setEnabled(enabled);
        nomeField.setEnabled(enabled);
        usernameField.setEnabled(enabled);
        senhaField.setEnabled(enabled);
        emailField.setEnabled(enabled);
    }
    Usuario usuarios_tela = new Usuario();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeLabel = new javax.swing.JLabel();
        senhaLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        cadastrarButton = new javax.swing.JButton();
        senhaField = new javax.swing.JPasswordField();
        emailLabel = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        usernameLabel = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nomeLabel.setText("Nome:");

        senhaLabel.setText("Senha:");

        cadastrarButton.setText("Cadastrar");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });

        emailLabel.setText("E-mail:");

        usernameLabel.setText("Username:");

        nomeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeFieldActionPerformed(evt);
            }
        });

        idLabel.setText("ID:");

        idField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(idLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(emailLabel)
                                        .addComponent(nomeLabel)
                                        .addComponent(senhaLabel)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(usernameLabel))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(cadastrarButton)))
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(cadastrarButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        // Cadastrar:
        // INSERT NO DB:
        if (operacaoAtivaGlobal.equals("Incluir")) {
            usuarios_tela.setNome(nomeField.getText());
            usuarios_tela.setSenha(new String(senhaField.getPassword()));
            usuarios_tela.setEmail(emailField.getText());
            usuarios_tela.setUsername(usernameField.getText());

            
            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("Usuarios", usuarios_tela.dadosSQLValues());
            
            nomeField.setText("");
            usernameField.setText("");
            senhaField.setText("");
            emailField.setText("");
        }
        
        
        if (operacaoAtivaGlobal.equals("Alteração")) {
            usuarios_tela.setNome(nomeField.getText());
            usuarios_tela.setSenha(new String(senhaField.getPassword()));
            usuarios_tela.setEmail(emailField.getText());
            usuarios_tela.setUsername(usernameField.getText());

            
            ConnectDAO objcon = new ConnectDAO();
            objcon.alteraRegistroJFBD("Usuarios",this.usuarios_tela.alteraDadosSQLValues(), this.usuarios_tela.termoSQLWhereByID());
            
            nomeField.setText("");
            usernameField.setText("");
            senhaField.setText("");
            emailField.setText("");
            
        }
        
        if (operacaoAtivaGlobal.equals("Exclusão")) {
            
            ConnectDAO objcon = new ConnectDAO();
            objcon.excluiRegistroJFBD("Usuarios", this.usuarios_tela.termoSQLWhereByID());
        }
        
        if (operacaoAtivaGlobal.equals("Alterar") || operacaoAtivaGlobal.equals("Excluir") ) {
            this.usuarios_tela.setId(this.idField.getText());
            
            ConnectDAO objcon = new ConnectDAO();
            List<String> dadosSQL = objcon.consultaRegistroJFBD("Usuarios", this.usuarios_tela.consultaSQLValues(), this.usuarios_tela.termoSQLWhereByID());
            
            this.usuarios_tela.importaSQLValues(dadosSQL);
            
            nomeField.setText(this.usuarios_tela.getNome());
            usernameField.setText(this.usuarios_tela.getUsername());
            emailField.setText(this.usuarios_tela.getEmail());
            senhaField.setText(this.usuarios_tela.getSenha());
            
            this.setAllVisible(true);
            if (operacaoAtivaGlobal.equals("Excluir") ){
                operacaoAtivaGlobal = "Exclusão";
                this.cadastrarButton.setText("Excluir");
                this.setAllEnabled(false);
                this.cadastrarButton.setEnabled(true);
            } else {
                operacaoAtivaGlobal = "Alteração";
                this.cadastrarButton.setText("Alterar");
            } 
        }
        
        
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void nomeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeFieldActionPerformed

    private void idFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idFieldActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_Usuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField nomeField;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JPasswordField senhaField;
    private javax.swing.JLabel senhaLabel;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
