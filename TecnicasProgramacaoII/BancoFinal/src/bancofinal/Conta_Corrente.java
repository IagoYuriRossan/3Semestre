package bancofinal;

public class Conta_Corrente {
    private String Num_conta;
    private String Num_agencia;
    private String ID_Cli;
    private float Saldo;

    public Conta_Corrente(String Num_conta, String Num_agencia, String ID_Cli, float Saldo ) {  
        this.Num_conta = Num_conta;
        this.Num_agencia = Num_agencia;
        this.ID_Cli = ID_Cli;
        this.Saldo = Saldo;    
    }
    
    public Conta_Corrente() {}
   
    public String getNum_conta() { return Num_conta; }    
    public void setNum_conta(String Num_conta){this.Num_conta = Num_conta; }
    
    public String getNum_agencia() {return Num_agencia;}
    public void setNum_agencia(String Num_agencia){this.Num_agencia = Num_agencia; }
    
    public String getID_Cli() {return ID_Cli;}
    public void setID_Cli(String ID_Cli){this.ID_Cli = ID_Cli; }
    
    public float getSaldo() {return Saldo;}
    public void setSaldo(float Saldo){this.Saldo = Saldo; }
    
    public String dadosSQLValues() {
        String dadosClientes;
        dadosClientes = "'"
                + this.getNum_agencia()+ "','"
                + this.getNum_conta()+ "','"
                + this.getID_Cli()+ "','"
                + this.getSaldo()+ "'";
        return dadosClientes;
    }
    
    }

