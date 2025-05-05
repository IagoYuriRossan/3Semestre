package bancofinal;

public class Usuarios {
    private String Senha;
    private int Num_AGE;
    private int Num_CC;
    
    public Usuarios(String Senha, int Num_AGE, int Num_CC) {
        // TODO code application logic here
        this.Senha = Senha;
        this.Num_AGE = Num_AGE;
        this.Num_CC = Num_CC;
    }
    
    public Usuarios() {}
    
    public String getSenha() { return Senha; }
    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getNum_AGE() { return Num_AGE; }
    public void setNum_AGE(int Num_AGE) {
        this.Num_AGE = Num_AGE;
    }

    public int getNum_CC() { return Num_CC; }
    public void setNum_CC(int Num_CC) {
        this.Num_CC = Num_CC;
    }
    
    public String dadosSQLValues() {
        String dadosClientes;
        dadosClientes = "'"
                + this.getSenha()+ "','"
                + this.getNum_AGE()+ "','"
                + this.getNum_CC()+ "'";
        return dadosClientes;
    }
}
