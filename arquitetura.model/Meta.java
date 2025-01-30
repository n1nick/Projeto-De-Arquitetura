package arquitetura.model;

public class Meta {
    
    private int id;
    private String descricao;
    private double valorMeta;
    private double progresso;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public double getValorMeta() {
        return valorMeta;
    }
    
    public void setValorMeta(double valorMeta) {
        this.valorMeta = valorMeta;
    }
    
    public double getProgresso() {
        return progresso;
    }
    
    public void setProgresso(double progresso) {
        this.progresso = progresso;
    }
    
}
