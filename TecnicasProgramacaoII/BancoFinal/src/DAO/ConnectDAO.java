package DAO;
 
/*
import java.util.List;
import java.util.ArrayList;
*/
import bancofinal.Agencia;
import bancofinal.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
// import javax.swing.table.AbstractTableModel;

public class ConnectDAO {
    Connection con;
    public Connection ConnectDB(){
        JOptionPane.showMessageDialog(null, "Inicia a classe para conexão com SQL SERVER!");
 
        String caminho = "jdbc:sqlserver://localhost:1433;databaseName=MOV_CONTA_CORRENTE;"
                + "encrypt=true;trustServerCertificate=true;"; 
        String usuario = "sa";
        String senha = ".";
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
            JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
            JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
        }
        return con;
        // con.close();
    }
    
    public void insereRegistroJFBD(String tabela, String strDados) {
        
        con = ConnectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "INSERT INTO dbo." + tabela + " "
                    + "VALUES (" + strDados + ")";
            JOptionPane.showMessageDialog(null, "String de Insert: " + sql);
            
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
            } catch(SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void alteraRegistroJFBD(String tabela, String strDados, String pesquisaId) {
        con = ConnectDB();
        
        {
            Statement stmt;
            try {
                stmt = con.createStatement();
                
                String sql = "UPDATE dbo." + tabela
                        + " SET " + strDados
                        + " WHERE (" + pesquisaId + ");";
                try {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
                } catch(SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
                }
            
                con.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }             
        }        
    }
    
    public void excluiRegistroJFBD(String tabela, String pesquisaId) {
        con = ConnectDB();
        
        {
            Statement stmt;
            try {
                stmt = con.createStatement();
                
                String sql = "DELETE dbo." + tabela
                        + " WHERE (" + pesquisaId + ");";
                try {
                    stmt.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Exclusão executada com sucesso!");
                } catch(SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
                }
            
                con.close();
            
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }             
        }        
    }
    
    public Cliente pesquisaClienteJFBD(String tabela, String pesquisaId) {
        Cliente clientesReturn = new Cliente();
        String tabelaSGBD = "CLIENTES";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();
            
            Statement stmt;
            try {
                stmt = con.createStatement();
                
                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;
                
                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if(dados.next() == false) {
                        
                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");
                        
                    } else {
                        clientesReturn.setNome(dados.getString(2));
                        clientesReturn.setCPF(dados.getString(3));
                        clientesReturn.setEndereco(dados.getString(4));
                        clientesReturn.setNumero(dados.getString(5));
                        clientesReturn.setComplemento(dados.getString(6));
                        clientesReturn.setBairro(dados.getString(7));
                        clientesReturn.setCidade(dados.getString(8));
                        clientesReturn.setUF(dados.getString(9));
                        clientesReturn.setCep(dados.getString(10));
                        clientesReturn.setEmail(dados.getString(11));
                    }
                    
                    con.close();
                    
                    return clientesReturn;
                    
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
                }
                
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientesReturn;
    }  
    
    
        public List<Cliente> consultaRegistroClienteBD(){
        con = ConnectDB();
        List<Cliente> clientes = new ArrayList<>();
        
        Statement stmt;
        
        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM CLIENTES";
        
            try{
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i=0;
                while (dados.next()){
                    if (i==0)
                    {
                    i++;

                    Cliente cliente = new Cliente(
                        "NOME_CLI",
                        "CPF_CLI",
                        "ENDE_CLI",
                        "NUME_CLI",
                        "COMPL_CLI",
                        "BAIR_CLI",
                        "CIDA_CLI",
                        "UF_CLI",
                        "CEP_CLI",
                        "EMAIL_CLI");
                        clientes.add(cliente);
                    }
                    Cliente cliente = new Cliente(
                        dados.getString("NOME_CLI"),
                        dados.getString("CPF_CLI"),
                        dados.getString("ENDE_CLI"),
                        dados.getString("NUME_CLI"),
                        dados.getString("COMPL_CLI"),
                        dados.getString("BAIR_CLI"),
                        dados.getString("CIDA_CLI"),
                        dados.getString("UF_CLI"),
                        dados.getString("CEP_CLI"),
                        dados.getString("EMAIL_CLI")
                    );
                    clientes.add(cliente);
                }
            con.close();
            return clientes; //lista;
    
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());            
            } 
            con.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    
    
    

    public Agencia pesquisaAgenciaJFBD(String tabela, String pesquisaId) {
        Agencia agenciasReturn = new Agencia();
        String tabelaSGBD = "AGENCIAS";
        if (tabela.equals(tabelaSGBD)) {
            con = ConnectDB();
            
            Statement stmt;
            try {
                stmt = con.createStatement();
                
                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;
                
                try {
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if(dados.next() == false) {
                        
                        JOptionPane.showMessageDialog(null, "Nenhum registro foi encontrado para essa pesquisa.");
                        
                    } else {
                        agenciasReturn.setNome(dados.getString(2));
                        agenciasReturn.setEndereco(dados.getString(3));
                        agenciasReturn.setNumero(dados.getString(4));
                        agenciasReturn.setNum_agencia(dados.getString(5));
                        agenciasReturn.setComplemento(dados.getString(6));
                        agenciasReturn.setBairro(dados.getString(7));
                        agenciasReturn.setCidade(dados.getString(8));
                        agenciasReturn.setUF(dados.getString(9));
                        agenciasReturn.setCEP(dados.getString(10));
                        agenciasReturn.setCNPJ(dados.getString(11));
                        agenciasReturn.setGerente(dados.getString(12));
                    }
                    
                    con.close();
                    
                    return agenciasReturn;
                    
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
                }
                
                con.close();
                
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return agenciasReturn;
        
    }
    
    public List<Agencia> consultaRegistroAgenciaBD(){
        con = ConnectDB();
        List<Agencia> agencias = new ArrayList<>();
        
        Statement stmt;
        
        try {
            stmt = con.createStatement();
            // Cria a string com a sentença SQL para excluir registro.
            String sql = "SELECT * FROM AGENCIAS";
        
            try{
                //Execute a sentença de delete7
                ResultSet dados = stmt.executeQuery(sql);
                JOptionPane.showMessageDialog(null, "Select executado com sucesso");
                int i=0;
                while (dados.next()){
                    if (i==0)
                    {
                    i++;

                    Agencia agencia = new Agencia(
                        "NOME_AGE",
                        "ENDE_AGE",
                        "NUMERO_AGE",
                        "NUME_AGE",
                        "COMPL_AGE",
                        "BAIR_AGE",
                        "CIDA_AGE",
                        "UF_AGE",
                        "CEP_AGE",
                        "CNPJ-AGE",
                        "GER_AGE");
                        agencias.add(agencia);
                    }
                    Agencia agencia = new Agencia(
                        dados.getString("NOME_AGE"),
                        dados.getString("ENDE_AGE"),
                        dados.getString("NUMERO_AGE"),
                        dados.getString("NUME_AGE"),
                        dados.getString("COMPL_AGE"),
                        dados.getString("BAIR_AGE"),
                        dados.getString("CIDA_AGE"),
                        dados.getString("UF_AGE"),
                        dados.getString("CEP_AGE"),
                        dados.getString("CNPJ_AGE"),
                        dados.getString("EMAIL_AGE")
                    );
                    agencias.add(agencia);
                }
            con.close();
            return agencias; //lista;
    
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());            
            } 
            con.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;  
    }
    

}


