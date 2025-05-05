package bancofinal;

public class Movimentacao {
        
    private String Num_Conta;
    private String Num_Agencia;
    private String Documento;
    private String Data_Mov;
    private String CredOuDeb;
    private int ID_Hist;
    private String Compl_Hist;
    private float Valor;
    private float Saldo;
    
    public Movimentacao(String Num_Conta, String Num_Agencia, String Documento,
            String Data_Mov, String CredOuDeb, int ID_Hist, String Compl_Hist,
            float Valor, float Saldo) {
        this.Num_Conta = Num_Conta;
        this.Num_Agencia = Num_Agencia;
        this.Documento = Documento;
        this.Data_Mov = Data_Mov;
        this.CredOuDeb = CredOuDeb;
        this.ID_Hist = ID_Hist;
        this.Compl_Hist = Compl_Hist;
        this.Valor = Valor;
        this.Saldo = Saldo;
    }
    
    public Movimentacao() {}

    public String getNum_Conta() { return Num_Conta; }
    public void setNum_Conta(String Num_Conta) {
        this.Num_Conta = Num_Conta;
    }

    public String getNum_Agencia() { return Num_Agencia; }
    public void setNum_Agencia(String Num_Agencia) {
        this.Num_Agencia = Num_Agencia;
    }

    public String getDocumento() { return Documento; }
    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getData_Mov() { return Data_Mov; }
    public void setData_Mov(String Data_Mov) {
        this.Data_Mov = Data_Mov;
    }

    public String getCredOuDeb() { return CredOuDeb; }
    public void setCredOuDeb(String CredOuDeb) {
        this.CredOuDeb = CredOuDeb;
    }

    public int getID_Hist() { return ID_Hist; }
    public void setID_Hist(int ID_Hist) {
        this.ID_Hist = ID_Hist;
    }

    public String getCompl_Hist() { return Compl_Hist; }
    public void setCompl_Hist(String Compl_Hist) {
        this.Compl_Hist = Compl_Hist;
    }

    public float getValor() { return Valor; }
    public void setValor(float Valor) {
        this.Valor = Valor;
    }

    public float getSaldo() { return Saldo; }
    public void setSaldo(float Saldo) {
        this.Saldo = Saldo;
    }
    
    public String dadosSQLValues() {
        String dadosClientes;
        dadosClientes = "'"
                + this.getNum_Agencia()+ "','"
                + this.getNum_Conta()+ "','"
                + this.getData_Mov()+ "','"
                + this.getDocumento()+ "','"
                + this.getCredOuDeb()+ "','"
                + this.getID_Hist()+ "','"
                + this.getCompl_Hist()+ "','"
                + this.getValor()+ "','"
                + this.getSaldo()+ "'";
        return dadosClientes;
    }
    
}
