/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DAO.ConnectDAO;
import bancofinal.Agencia;

/**
 *
 * @author Alunos
 */
public class Cad_Agencia extends javax.swing.JFrame {

    /**
     * Creates new form Cad_Agencia
     */
    String operacaoAtivaGlobal = "Nenhum";
    public Cad_Agencia() {
        initComponents();
    }
    
    public Cad_Agencia(String operacaoAtiva) {
       initComponents();
       operacaoAtivaGlobal = operacaoAtiva;
       String operacao = "Incluir";
       
       if(operacaoAtiva.equals(operacao)) {
            agenciaLabel.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            jLabel11.setVisible(true);
            agenciaField.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);
            jTextField7.setVisible(true);
            jTextField9.setVisible(true);
            jTextField10.setVisible(true);
            jTextField11.setVisible(true);
            jComboBox1.setVisible(true);
            jButton1.setText("Incluir BD");
       }
       
       operacao = "Alterar";
       if(operacaoAtiva.equals(operacao)) {
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
            jLabel11.setVisible(false);
            agenciaLabel.setVisible(false);
            jLabel12.setVisible(true);
            jTextField2.setVisible(false);
            agenciaField.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jTextField7.setVisible(false);
            jTextField9.setVisible(false);
            jTextField10.setVisible(false);
            jTextField11.setVisible(false);
            jTextField8.setVisible(true);
            jComboBox1.setVisible(false);
            jButton1.setText("Pesquisar");
       }
       
       operacao = "Consultar";
       if(operacaoAtiva.equals(operacao)) {
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
            agenciaLabel.setVisible(false);
            jLabel12.setVisible(true);
            jTextField2.setVisible(false);
            agenciaField.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jTextField7.setVisible(false);
            jTextField9.setVisible(false);
            jTextField10.setVisible(false);
            jTextField11.setVisible(false);
            jTextField8.setVisible(true);
            jComboBox1.setVisible(false);
            jButton1.setText("PesquisaConsulta");
       }
       
       operacao = "Excluir";
       if(operacaoAtiva.equals(operacao)) {
            jLabel2.setVisible(false);
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel7.setVisible(false);
            jLabel8.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
            agenciaLabel.setVisible(false);
            jLabel12.setVisible(true);
            jTextField2.setVisible(false);
            agenciaField.setVisible(false);
            jTextField3.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jTextField6.setVisible(false);
            jTextField7.setVisible(false);
            jTextField9.setVisible(false);
            jTextField10.setVisible(false);
            jTextField11.setVisible(false);
            jTextField8.setVisible(true);
            jComboBox1.setVisible(false);
            jButton1.setText("Pesquisar");
       }
       
    }
    
    Agencia agencia_tela = new Agencia();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        agenciaLabel = new javax.swing.JLabel();
        agenciaField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        agenciaLabel.setText("Número da Agência:");

        agenciaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agenciaFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Número:");

        jLabel5.setText("Complemento:");

        jLabel6.setText("Bairro:");

        jLabel7.setText("Cidade:");

        jLabel8.setText("UF:");

        jLabel9.setText("CEP:");

        jLabel10.setText("CNPJ:");

        jLabel11.setText("Gerente:");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC", "SP", "SE", "TO" }));

        jButton2.setText("Limpar tela");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Ler");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel12.setText("ID Agencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agenciaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(agenciaField, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField11))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField8)
                        .addGap(203, 203, 203)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agenciaLabel)
                    .addComponent(agenciaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Insert:
        String operacao = "Incluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            agencia_tela.setNome(jTextField2.getText());
            agencia_tela.setNum_agencia(agenciaField.getText());
            agencia_tela.setEndereco(jTextField3.getText());
            agencia_tela.setNumero(jTextField4.getText());
            agencia_tela.setComplemento(jTextField5.getText());
            agencia_tela.setBairro(jTextField6.getText());
            agencia_tela.setCidade(jTextField7.getText());
            agencia_tela.setCEP(jTextField9.getText());
            agencia_tela.setCNPJ(jTextField10.getText());
            agencia_tela.setGerente(jTextField11.getText());
            agencia_tela.setUF(jComboBox1.getSelectedItem().toString());
            
            ConnectDAO objcon = new ConnectDAO();
            objcon.insereRegistroJFBD("AGENCIAS", agencia_tela.dadosSQLValues());
            
            agenciaField.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
            jTextField5.setText("");
            jTextField6.setText("");
            jTextField7.setText("");
            jTextField9.setText("");
            jTextField10.setText("");
            jTextField11.setText("");
            jComboBox1.setSelectedItem("AC");
        }
        
        //ALTERAR
        operacao = "Alteração";
        if (operacaoAtivaGlobal.equals(operacao)) {
            
            ConnectDAO objcon = new ConnectDAO();
            agencia_tela.setNome(jTextField2.getText());
            agencia_tela.setNum_agencia(agenciaField.getText());
            agencia_tela.setEndereco(jTextField3.getText());
            agencia_tela.setNumero(jTextField4.getText());
            agencia_tela.setComplemento(jTextField5.getText());
            agencia_tela.setBairro(jTextField6.getText());
            agencia_tela.setCidade(jTextField7.getText());
            agencia_tela.setCEP(jTextField9.getText());
            agencia_tela.setCNPJ(jTextField10.getText());
            agencia_tela.setGerente(jTextField11.getText());
            agencia_tela.setUF(jComboBox1.getSelectedItem().toString());
            
            objcon.alteraRegistroJFBD("AGENCIAS", agencia_tela.alteraDadosSQLValues(),"ID_AGE='"+jTextField8.getText()+"'");
            
            jTextField2.setText("");//NOME
            agenciaField.setText("");//Numero da Agencia
            jTextField3.setText("");//Endereço
            jTextField4.setText("");//Numero do Endereço
            jTextField5.setText("");//Complemento
            jTextField6.setText("");//Bairro
            jTextField7.setText("");//Cidade
            jTextField8.setText("");//ID
            jTextField9.setText("");//CEP
            jTextField10.setText("");//CNPJ
            jTextField8.setText("");//GERENTE
            jComboBox1.setSelectedItem("AC");
            this.dispose();
        }
        
                operacao = "Alterar";
        if (operacaoAtivaGlobal.equals(operacao)) {
            
            ConnectDAO objcon = new ConnectDAO();
            agencia_tela = objcon.pesquisaAgenciaJFBD("AGENCIAS", "ID_AGE='" + jTextField8.getText() + "'");
            agenciaField.setText(agencia_tela.getNum_agencia());
            jTextField2.setText(agencia_tela.getNome());
            jTextField3.setText(agencia_tela.getEndereco());
            jTextField4.setText(agencia_tela.getNumero());
            jTextField5.setText(agencia_tela.getComplemento());
            jTextField6.setText(agencia_tela.getBairro());
            jTextField7.setText(agencia_tela.getCidade());
            jComboBox1.setSelectedItem(agencia_tela.getUF());
            jTextField9.setText(agencia_tela.getCEP());
            jTextField10.setText(agencia_tela.getCNPJ());
            jTextField11.setText(agencia_tela.getGerente());
            
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            jLabel11.setVisible(true);
            agenciaLabel.setVisible(true);
            jLabel12.setVisible(true);
            jTextField2.setVisible(true);
            agenciaField.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);
            jTextField7.setVisible(true);
            jTextField9.setVisible(true);
            jTextField10.setVisible(true);
            jTextField11.setVisible(true);
            jTextField8.setVisible(true);
            jComboBox1.setVisible(true);
            jButton1.setText("Alterar");
            operacaoAtivaGlobal = "Alteração";
        }
        
        
        //CONSULTAR
        operacao = "Consultar";
        if (operacaoAtivaGlobal.equals(operacao)) {
            
            ConnectDAO objcon = new ConnectDAO();
            agencia_tela = objcon.pesquisaAgenciaJFBD("AGENCIAS", "ID_AGE='" + jTextField8.getText() + "'");
            agenciaField.setText(agencia_tela.getNum_agencia());
            jTextField2.setText(agencia_tela.getNome());
            jTextField3.setText(agencia_tela.getEndereco());
            jTextField4.setText(agencia_tela.getNumero());
            jTextField5.setText(agencia_tela.getComplemento());
            jTextField6.setText(agencia_tela.getBairro());
            jTextField7.setText(agencia_tela.getCidade());
            jComboBox1.setSelectedItem(agencia_tela.getUF());
            jTextField9.setText(agencia_tela.getCEP());
            jTextField10.setText(agencia_tela.getCNPJ());
            jTextField11.setText(agencia_tela.getGerente());
            
            agenciaLabel.setVisible(true);
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            jLabel11.setVisible(true);
            agenciaField.setVisible(true);
            jTextField2.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);
            jTextField7.setVisible(true);
            jTextField9.setVisible(true);
            jTextField10.setVisible(true);
            jTextField11.setVisible(true);
            jComboBox1.setVisible(true);
        }
        
        
        //EXCLUIR
        operacao = "Exclusão";
        if (operacaoAtivaGlobal.equals(operacao)) {
            
            ConnectDAO objcon = new ConnectDAO();
            
            objcon.excluiRegistroJFBD("AGENCIAS","ID_AGE='"+jTextField8.getText()+"'");
            
            jTextField2.setText("");//NOME
            agenciaField.setText("");//Numero da Agencia
            jTextField3.setText("");//Endereço
            jTextField4.setText("");//Numero do Endereço
            jTextField5.setText("");//Complemento
            jTextField6.setText("");//Bairro
            jTextField7.setText("");//Cidade
            jTextField8.setText("");//ID
            jTextField9.setText("");//CEP
            jTextField10.setText("");//CNPJ
            jTextField8.setText("");//GERENTE
            jComboBox1.setSelectedItem("AC");
            this.dispose();
        }
        
        operacao = "Excluir";
        if (operacaoAtivaGlobal.equals(operacao)) {
            
            ConnectDAO objcon = new ConnectDAO();
            agencia_tela = objcon.pesquisaAgenciaJFBD("AGENCIAS", "ID_AGE='" + jTextField8.getText() + "'");
            agenciaField.setText(agencia_tela.getNum_agencia());
            jTextField2.setText(agencia_tela.getNome());
            jTextField3.setText(agencia_tela.getEndereco());
            jTextField4.setText(agencia_tela.getNumero());
            jTextField5.setText(agencia_tela.getComplemento());
            jTextField6.setText(agencia_tela.getBairro());
            jTextField7.setText(agencia_tela.getCidade());
            jComboBox1.setSelectedItem(agencia_tela.getUF());
            jTextField9.setText(agencia_tela.getCEP());
            jTextField10.setText(agencia_tela.getCNPJ());
            jTextField11.setText(agencia_tela.getGerente());
            
            jLabel2.setVisible(true);
            jLabel3.setVisible(true);
            jLabel4.setVisible(true);
            jLabel5.setVisible(true);
            jLabel6.setVisible(true);
            jLabel7.setVisible(true);
            jLabel8.setVisible(true);
            jLabel9.setVisible(true);
            jLabel10.setVisible(true);
            jLabel11.setVisible(true);
            agenciaLabel.setVisible(true);
            jLabel12.setVisible(true);
            jTextField2.setVisible(true);
            agenciaField.setVisible(true);
            jTextField3.setVisible(true);
            jTextField4.setVisible(true);
            jTextField5.setVisible(true);
            jTextField6.setVisible(true);
            jTextField7.setVisible(true);
            jTextField9.setVisible(true);
            jTextField10.setVisible(true);
            jTextField11.setVisible(true);
            jTextField8.setVisible(true);
            jComboBox1.setVisible(true);
            // Agora cancela a opção do usuário editar os campos, deixando somentes para leitura
            jTextField2.setEditable(false);
            agenciaField.setEditable(false);
            jTextField3.setEditable(false);
            jTextField4.setEditable(false);
            jTextField5.setEditable(false);
            jTextField6.setEditable(false);
            jTextField7.setEditable(false);
            jTextField8.setEditable(false);
            jTextField9.setEditable(false);
            jTextField10.setEditable(false);
            jTextField11.setEditable(false);
            jComboBox1.setEditable(false);
            jButton1.setText("Excluir");
            operacaoAtivaGlobal = "Exclusão";
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Limpar:
        agenciaField.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jComboBox1.setSelectedItem("AC");
        jTextField9.setText("");
        jTextField10.setText("");
        jTextField11.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Ler:
        agenciaField.setText(agencia_tela.getNum_agencia());
        jTextField2.setText(agencia_tela.getNome());
        jTextField3.setText(agencia_tela.getEndereco());
        jTextField4.setText(agencia_tela.getNumero());
        jTextField5.setText(agencia_tela.getComplemento());
        jTextField6.setText(agencia_tela.getBairro());
        jTextField7.setText(agencia_tela.getCidade());
        jComboBox1.setSelectedItem(agencia_tela.getUF());
        jTextField9.setText(agencia_tela.getCEP());
        jTextField10.setText(agencia_tela.getCNPJ());
        jTextField11.setText(agencia_tela.getGerente());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void agenciaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agenciaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agenciaFieldActionPerformed

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
            java.util.logging.Logger.getLogger(Cad_Agencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cad_Agencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cad_Agencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cad_Agencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Cad_Agencia().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agenciaField;
    private javax.swing.JLabel agenciaLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
