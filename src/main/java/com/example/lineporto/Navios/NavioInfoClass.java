package com.example.lineporto.Navios;

public class NavioInfoClass {
    
    private String nome;
    private String empresa;
    private String tipoCarga;
    private double tamanho;
    private double largura;
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


