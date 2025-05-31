package bancofinal;
 
import javax.swing.JOptionPane;
 
public class Agencia {
    private String Nome;
    private String Endereco;
    private String Numero;
    private String Num_agencia;
    private String Complemento;
    private String Bairro;
    private String Cidade;
    private String UF;
    private String CEP;
    private String CNPJ;
    private String Gerente;
 
    public Agencia(String Nome, String Endereco, String Numero,
            String Num_agencia, String Complemento, String Bairro, String Cidade,
            String UF, String CEP, String CNPJ, String Gerente) {
        this.Nome = Nome;
        this.Endereco = Endereco;
        this.Numero = Numero;
        this.Num_agencia = Num_agencia;
        this.Complemento = Complemento;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.UF = UF;
        this.CEP = CEP;
        this.CNPJ = CNPJ;
        this.Gerente = Gerente;
    }
    
    public Agencia() {}
    
    public String getNum_agencia() { return Num_agencia; }
    public void setNum_agencia(String Num_agencia) {
        if (Num_agencia.isEmpty() || Num_agencia.isBlank()) {
            JOptionPane.showMessageDialog(null, "Número da agência não pode ser nulo, vazio ou em branco!");
        }
        this.Num_agencia = Num_agencia;
    }
 
    public String getNome() { return Nome; }
    public void setNome(String Nome) {
        if (Nome.isEmpty() || Nome.isBlank()) {
            JOptionPane.showMessageDialog(null, "Nome não pode ser nulo, vazio ou em branco!");
        }
        this.Nome = Nome;
    }
 
    public String getEndereco() { return Endereco; }
    public void setEndereco(String endereco) {
        if (endereco.isEmpty() || endereco.isBlank()) {
            JOptionPane.showMessageDialog(null, "Endereço não pode ser nulo, vazio ou em branco!");
        }
        if (endereco.length() < 4) {
            JOptionPane.showMessageDialog(null, "Endereço inválido!");
        }
        this.Endereco = endereco;
    }
 
    public String getNumero() { return Numero; }
    public void setNumero(String Numero) { this.Numero = Numero; }
 
    public String getComplemento() { return Complemento; }
    public void setComplemento(String Complemento) { this.Complemento = Complemento; }
 
    public String getBairro() { return Bairro; }
    public void setBairro(String Bairro) { this.Bairro = Bairro; }
 
    public String getCidade() { return Cidade; }
    public void setCidade(String Cidade) {
        if (Cidade.isEmpty() || Cidade.isBlank()) {
            JOptionPane.showMessageDialog(null, "Cidade não pode ser nulo, vazio ou em branco!");
        }
        this.Cidade = Cidade;
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
            JOptionPane.showMessageDialog(null, "UF registrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "UF inválido!");
        }
    }
 
    public String getCEP() { return CEP; }
    public void setCEP(String Cep) {
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
        this.CEP = Cep;
    }
 
    public String getCNPJ() { return CNPJ; }
    public void setCNPJ(String cnpj) {
        if (cnpj == null || cnpj.isEmpty()) {
            JOptionPane.showMessageDialog(null, "CNPJ não pode ser nulo ou vazio!");
        }
        cnpj = cnpj.replace(".", "").replace("-", "").replace("/", ""); // remove formatting
        if (cnpj.length() != 14) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido");
        }
 
        int[] digitos = new int[14];
        for (int i = 0; i < 14; i++) {
            digitos[i] = Integer.parseInt(String.valueOf(cnpj.charAt(i)));
        }
 
        int soma = 0;
        int tamanho = 5;
        for (int i = 0; i < 12; i++) {
            soma += digitos[i] * tamanho;
            tamanho--;
            if (tamanho < 2) {
                tamanho = 9;
            }
        }
 
        int digitoVerificador = soma % 11;
        if (digitoVerificador < 2) {
            digitoVerificador = 0;
        } else {
            digitoVerificador = 11 - digitoVerificador;
        }
 
        if (digitoVerificador != digitos[12]) {
            JOptionPane.showMessageDialog(null, "CNPJ inválido");
        }
 
        soma = 0;
        tamanho = 6;
        for (int i = 0; i < 13; i++) {
            soma += digitos[i] * tamanho;
            tamanho--;
            if (tamanho < 2) {
                tamanho = 9;
            }
        }
 
        digitoVerificador = soma % 11;
        if (digitoVerificador < 2) {
            digitoVerificador = 0;
        } else {
            digitoVerificador = 11 - digitoVerificador;
        }
        if (digitoVerificador == digitos[13]) {
            System.out.print("CNPJ cadastrado com sucesso!");
        }
        this.CNPJ = cnpj;
    }
 
    public String getGerente() { return Gerente; }
    public void setGerente(String Gerente) {
        if (Gerente == null || Gerente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Gerente não pode ser nulo ou vazio!");
        }
        this.Gerente = Gerente;
    }
    public String dadosSQLValues() {
        String dadosAgencias;
        dadosAgencias = "'"
                + this.getNome() + "','"
                + this.getEndereco()+ "','"
                + this.getNumero()+ "','"
                + this.getNum_agencia() + "','"
                + this.getComplemento()+ "','"
                + this.getBairro()+ "','"
                + this.getCidade()+ "','"
                + this.getUF()+ "','"
                + this.getCEP()+ "','"
                + this.getCNPJ()+ "','"
                + this.getGerente()+ "'";
        return dadosAgencias;
    }
    public String alteraDadosSQLValues() {
        String dadosAgencias;
        dadosAgencias =
                "NOME_AGE='" + this.getNome() +
                "',ENDE_AGE='" + this.getEndereco()+
                "',NUMERO='" + this.getNumero()+
                "',NUME_AGE='" + this.getNum_agencia()+
                "',COMPL_AGE='" + this.getComplemento()+
                "',BAIR_AGE='" + this.getBairro()+
                "',CIDA_AGE='" + this.getCidade()+
                "',UF_AGE='" + this.getUF()+
                "',CEP_AGE='" + this.getCEP()+
                "',CNPJ_AGE='" + this.getCNPJ()+
                "',GER_AGE='" + this.getGerente()+ "'";
        return dadosAgencias;
    }
}