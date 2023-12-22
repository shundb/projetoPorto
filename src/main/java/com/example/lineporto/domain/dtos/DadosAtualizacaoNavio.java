package com.example.lineporto.domain.dtos;

public record DadosAtualizacaoNavio(
        Long id,
        String imo,
        String nome,
        double comprimento,
        double largura,
        double dwt,
        String produto,
        String agente,
        String empresa
) {
}
