package bancofinal;

public class Historico {
    private String ID_Hist;
    private String Historico;

    public Historico(String ID_Hist, String Historico) {
        this.ID_Hist = ID_Hist;
        this.Historico = Historico;    
    }
    
    public Historico() {}

    public String getID_Hist() { return ID_Hist; }
    public void setID_Hist(String ID_Hist) { this.ID_Hist = ID_Hist; }

    public String getHistorico() { return Historico; }
    public void setHistorico(String Historico) { this.Historico = Historico; }
    
    public String dadosSQLValues() {
        String dadosClientes;
        dadosClientes = "'"
                + this.getHistorico()+ "'";
        return dadosClientes;
    }
    
}
