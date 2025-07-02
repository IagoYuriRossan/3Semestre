package classes;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.JOptionPane;

public class Usuario {
    
    private String Id;
    private String Username;
    private String Nome;
    private String Senha;
    private String Email;

    // Construtor com validações seguras
    public Usuario(String id, String Nome, String Senha, String Email, String Username) {
        this.Id = Id;
        this.Nome = Nome;
        this.Email = Email;
        this.Senha = Senha;
        this.Username = Username;

        // Validação direta da senha (evita chamada ao setter dentro do construtor)
        if (Senha == null || Senha.trim().isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }
        if (!Senha.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula.");
        }
        if (!Senha.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra minúscula.");
        }
        if (!Senha.matches(".*[!@#$%^&*()_+\\[\\]{}|;:',.<>/?].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um caractere especial.");
        }

        this.Senha = Senha;
    }
    
    // Construtor vazio
    public Usuario() {}

    // Nome
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        if (Nome == null || Nome.isEmpty() || Nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome não pode ser nulo, vazio ou em branco!");
        }
        this.Nome = Nome;
    }
    
    public String getUsername() {
        return Username;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    
    
    public void setUsername(String Username) {
        if (Username == null || Username.isEmpty() || Username.isBlank()) {
            JOptionPane.showMessageDialog(null, "Username não pode ser nulo, vazio ou em branco!");
        }
        this.Username = Username;
    }
    
    // Senha com validação
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        if (Senha == null || Senha.trim().isEmpty()) {
            throw new IllegalArgumentException("A senha é obrigatória.");
        }
        if (!Senha.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra maiúscula.");
        }
        if (!Senha.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos uma letra minúscula.");
        }
        if (!Senha.matches(".*[!@#$%^&*()_+\\[\\]{}|;:',.<>/?].*")) {
            throw new IllegalArgumentException("A senha deve conter pelo menos um caractere especial.");
        }

        this.Senha = Senha;
    }

    // Email com validação
    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (Email == null || Email.isEmpty() || Email.isBlank()) {
            JOptionPane.showMessageDialog(null, "Email não pode ser nulo, vazio ou em branco!");
        }

        if (!Email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Email inválido!");
        }

        this.Email = Email;
    }
    
    public String dadosSQLValues() {
        String dadosUsuarios;
        dadosUsuarios = "'"
                + this.getNome() + "','"
                + this.getUsername()+ "','"
                + this.getEmail() + "','"
                + this.getSenha() + "'";
                
        JOptionPane.showMessageDialog(null, "Retorno dadosSQLValues: "+dadosUsuarios);
        return dadosUsuarios;
    }
    
    public String alteraDadosSQLValues() {
        String dadosUsuarios;
        dadosUsuarios =
                "Nome='" + this.getNome() +
                "',Username='" + this.getUsername()+
                "',Email='" + this.getEmail()+
                "',Senha='" + this.getSenha()+"'";
        return dadosUsuarios;
    }
    
    public String termoSQLWhereByID() {
        return "Id = "+this.getId();
    }
    
    public String consultaSQLValues() {
        return "Nome, Username, Email, Senha";
    }
    
    public void importaSQLValues(List<String> dados){
        System.out.println(dados);
        System.out.println(dados.size());
        if (dados.size() != 4){
            throw new IllegalArgumentException("Numero de dados inválido, esperando 4");
        }
        this.setNome(dados.get(0));
        this.setUsername(dados.get(1));
        this.setEmail(dados.get(2));
        this.setSenha(dados.get(3));
    }
}
