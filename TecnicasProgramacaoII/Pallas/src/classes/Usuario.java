package classes;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Usuario {

    private String Nome;
    private String Senha;
    private String Email;
    private LocalDateTime dataCriacao;

    // Construtor com validações seguras
    public Usuario(String Nome, String Senha, String Email, BufferedImage Foto) {
        this.Nome = Nome;
        this.Email = Email;

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

        // Define a data de criação diretamente
        this.dataCriacao = LocalDateTime.now();
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

        // Se a data de criação ainda não foi definida, define agora
        if (this.dataCriacao == null) {
            this.dataCriacao = LocalDateTime.now();
        }
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

    // Data de criação
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String dadosSQLValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
