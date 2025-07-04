package DAO;
 
/*
import java.util.List;
import java.util.ArrayList;
*/
//import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.util.ArrayList;
import javax.swing.JOptionPane;
// import javax.swing.table.AbstractTableModel;

public class ConnectDAO {
    Connection con;
    public Connection ConnectDB(){
        JOptionPane.showMessageDialog(null, "Inicia a classe para conexão com SQL SERVER!");
 
        String caminho = "jdbc:sqlserver://localhost:1433;databaseName=Pallas;"
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
                    + " VALUES (" + strDados + ")";
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
    
    public List<String> consultaRegistroJFBD(String tabela, String consultaCampos, String condicaoWhere) {
        con = ConnectDB();
        
        Statement stmt;
        ResultSet dados;
        List<String> lista = new ArrayList<>();
        try {
            stmt = con.createStatement();
            
            String sql = "SELECT "+consultaCampos+" FROM dbo."+tabela+" WHERE "+condicaoWhere;
            
            System.out.println(sql);
            
            try {
                dados = stmt.executeQuery(sql);
                if (!dados.next()) {
                    JOptionPane.showMessageDialog(null, "Registro não encontrado!");
                }
                
                int columnCount = dados.getMetaData().getColumnCount();
                for (int index = 1; index <= columnCount; index++){
                    lista.add(dados.getString(index));
                }
            } catch (SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
    public ResultSet consultaTodoRegistroJFBD(String tabela, String consultaCampos) {
        con = ConnectDB();
        
        Statement stmt;
        ResultSet dados;
        try {
            stmt = con.createStatement();
            
            String sql = "SELECT "+consultaCampos+" FROM dbo."+tabela;
            
            System.out.println(sql);
            
            try {
                dados = stmt.executeQuery(sql);
                System.out.println(dados);
                return dados;
                
            } catch (SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro de conexão, connectDAO - Mensagem => "+erro.getMessage());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Estado => "+erro.getSQLState());
                JOptionPane.showMessageDialog(null, "\n Erro de conexão, connectDAO - Código => "+erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex){
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}


