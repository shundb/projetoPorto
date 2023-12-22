package com.example.lineporto.domain.entities.Navio;

public class NavioInfoClass {

    private String imo;
    private String nome;
    private double comprimento;
    private double largura;
    private double dwt;

//  Verificar se 1 navio pode ter mais de 1 tipo de produto embarcado,
//  a relação é diferente se sim
//  private String produto;
    private String agente;
    private String tipoCarga;
    private double tamanho;
    private double profundidade;
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    public String getTipoCarga() {
        return tipoCarga;
    }
    
    
    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }
    
    public double getTamanho() {
        return tamanho;
    }
    
    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }
    
    public double getLargura() {
        return largura;
    }
    
    public void setLargura(double largura) {
        this.largura = largura;
    }
    
    public double getProfundidade() {
        return profundidade;
    }
    
    public void setProfundidade(double profundidade) {
        this.profundidade = profundidade;
    }
}


