package com.example.lineporto.domain.dtos;

import com.example.lineporto.domain.entities.Navio.Navio;

public record DadosListagemNavioDTO(String imo, String nome, double comprimento, double largura, double dwt, String produto, String agente, String empresa) {
    public DadosListagemNavioDTO(Navio navio) {
        this(navio.getImo(), navio.getNome(), navio.getComprimento(), navio.getLargura(), navio.getDwt(), navio.getProduto(), navio.getAgente(), navio.getEmpresa());
    }
}
