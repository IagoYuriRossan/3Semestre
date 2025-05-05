package bancofinal;

import javax.swing.JOptionPane;

public class Clientes {
    private String Nome;
    private String CPF;
    private String Endereco;
    private String Numero;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String UF;
    private String Cep;
    private String Email;
    
    public Clientes(String Nome, String CPF, String Endereco,
            String Numero, String Complemento, String Bairro, String Cidade,
            String UF, String Cep, String Email) {
        this.Nome = Nome;
        this.CPF = CPF;
        this.Endereco = Endereco;
        this.Numero = Numero;
        this.Complemento = Complemento;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.UF = UF;
        this.Cep = Cep;
        this.Email = Email;
    }
    
    public Clientes() {}

    public String getNome() { return Nome; }
    public void setNome(String Nome) {
        if (Nome.isEmpty() || Nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome não pode ser nulo, vazio ou em branco!");
        }
        this.Nome = Nome;
    }

    public String getCPF() { return CPF; }
    public void setCPF(String CPF) {
        if (CPF.isEmpty() || CPF.isBlank()) {
            JOptionPane.showMessageDialog(null, "CPF não pode ser nulo, vazio ou em branco!");
        }
        CPF = CPF.replace(".", "").replace("-", "");
        if (CPF.length() != 11) {
            JOptionPane.showMessageDialog(null, "CPF inválido");
        }

        int[] digitos = new int[11];
        for (int i = 0; i < 11; i++) {
            digitos[i] = Integer.parseInt(String.valueOf(CPF.charAt(i)));
        }

        int soma = 0;
        int tamanho = 10;
        for (int i = 0; i < 9; i++) {
            soma += digitos[i] * tamanho;
            tamanho--;
        }

        int digitoVerificador = (soma * 10) % 11;
        if (digitoVerificador == 10 || digitoVerificador == 11) {
            digitoVerificador = 0;
        }

        if (digitoVerificador != digitos[9]) {
            JOptionPane.showMessageDialog(null, "CPF inválido");
        }

        soma = 0;
        tamanho = 11;
        for (int i = 0; i < 10; i++) {
            soma += digitos[i] * tamanho;
            tamanho--;
        }

        digitoVerificador = (soma * 10) % 11;
        if (digitoVerificador == 10 || digitoVerificador == 11) {
            digitoVerificador = 0;
        }

        if (digitoVerificador == digitos[10]) {
            this.CPF = CPF;
        }
    }

    public String getUF() { return UF; }
    public void setUF(String UF) {
        String[] estados = {
            "AC","AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS",
            "MG", "PA", "PB", "PR", "PE", "PI", "RR", "RO", "RJ", "RN", "RS", "SC",
            "SP", "SE", "TO"
        };
        boolean UFValido = false;
        
        if (UF.isEmpty() || UF.isBlank()) {
            JOptionPane.showMessageDialog(null, "UF não pode ser nulo, vazio ou em branco!");
        }
        if (UF.length() < 2) {
            JOptionPane.showMessageDialog(null, "UF inválido!");
        }
        
        for (String estado : estados) {
            if (UF.equals(estado)) {
                UFValido = true;
            }
        }
        
        if (UFValido) {
            this.UF = UF;
        } else {
            JOptionPane.showMessageDialog(null, "UF inválido!");
        }
    }

    public String getCep() { return Cep; }
    public void setCep(String Cep) {
        // Regex para validar o formato do CEP
        String regex = "^[0-9]{5}[0-9]{3}$";

        // Verifica se o CEP é nulo ou vazio
        if (Cep == null || Cep.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CEP não pode ser nulo ou vazio!");
        }

        // Valida o formato do CEP
        if (!Cep.matches(regex)) {
            JOptionPane.showMessageDialog(null, "CEP inválido!");
        }
        
        Cep = Cep.replace("-", "");
        
        this.Cep = Cep;
    }

    public String getEmail() { return Email; }
    public void setEmail(String Email) {
        // Regex para validar o formato do email
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Verifica se o email é nulo ou vazio
        if (Email.isEmpty() || Email.isBlank()) {
            JOptionPane.showMessageDialog(null, "Email não pode ser nulo, vazio ou em branco!");
        }

        // Valida o formato do email
        if (!Email.matches(regex)) {
            JOptionPane.showMessageDialog(null, "Email inválido!");
        }

        this.Email = Email;
    }
    
    public String getEndereco() {return Endereco;}
    public void setEndereco(String endereco){
        if (endereco.isEmpty() || endereco.isBlank()) {
            JOptionPane.showMessageDialog(null, "Endereço não pode ser nulo, vazio ou em branco!");
        }
        if (endereco.length() < 4) {
            JOptionPane.showMessageDialog(null, "Endereço inválido!");
        }
        this.Endereco = endereco;
    }
    
    public String getNumero() {return Numero;}
    public void setNumero(String Numero){
        if (Numero.isEmpty() || Numero.isBlank()) {
            JOptionPane.showMessageDialog(null, "Número não pode ser nulo, vazio ou em branco!");
        }
        this.Numero = Numero;
    }

    public String getComplemento() {return Complemento;}
    public void setComplemento(String Complemento){ this.Complemento = Complemento; }
    
    public String getBairro() {return Bairro;}
    public void setBairro(String Bairro){this.Bairro = Bairro; }
    
    public String getCidade() {return Cidade;}
    public void setCidade(String Cidade){
        if (Cidade.isEmpty() || Cidade.isBlank()) {
            JOptionPane.showMessageDialog(null, "Cidade não pode ser nulo, vazio ou em branco!");
        }
        this.Cidade = Cidade;
    }
    
    public String dadosSQLValues() {
        String dadosClientes;
        dadosClientes = "'"
                + this.getNome() + "','"
                + this.getCPF()+ "','"
                + this.getEndereco() + "','"
                + this.getNumero() + "','"
                + this.getComplemento()+ "','"
                + this.getBairro()+ "','"
                + this.getCidade() + "','"
                + this.getUF() + "','"
                + this.getCep()+ "','"
                + this.getEmail() + "'";
        JOptionPane.showMessageDialog(null, "Retorno dadosSQLValues: "+dadosClientes);
        return dadosClientes;
    }
    
    public String alteraDadosSQLValues() {
        String dadosClientes;
        dadosClientes = "NOME_CLI='"
                + this.getNome() + "',CPF_CLI='"
                + this.getCPF()+ "',ENDE_CLI='"
                + this.getEndereco() + "',NUME_CLI='"
                + this.getNumero() + "',COMPL_CLI='"
                + this.getComplemento()+ "',BAIR_CLI='"
                + this.getBairro()+ "',CIDA_CLI='"
                + this.getCidade() + "',UF_CLI='"
                + this.getUF() + "',CEP_CLI='"
                + this.getCep()+ "',EMAIL_CLI='"
                + this.getEmail() + "'";
        return dadosClientes;
    }
    
    }
    