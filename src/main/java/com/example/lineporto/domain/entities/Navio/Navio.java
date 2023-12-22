package com.example.lineporto.domain.entities.Navio;


import com.example.lineporto.domain.dtos.DadosAtualizacaoNavio;
import com.example.lineporto.domain.dtos.DadosCadastroNavioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tb_navios")
@Entity(name = "Navio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Navio {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imo;
    private String nome;
    private double comprimento;
    private double largura;
    private double dwt;
    private String produto;
    private String agente;
    private String empresa;
    private Boolean ativo;

    public Navio(DadosCadastroNavioDTO dados) {
        this.imo = dados.imo();
        this.nome = dados.nome();
        this.comprimento = dados.comprimento();
        this.largura = dados.largura();
        this.dwt = dados.dwt();
        this.produto = dados.produto();
        this.agente = dados.agente();
        this.empresa = dados.empresa();
        this.ativo = true;
    }

    public void atualizarInformacao(DadosAtualizacaoNavio dados) {

        if (dados.imo() != null) {
            this.imo = dados.imo();
        }

        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        this.comprimento = dados.comprimento();

        this.largura = dados.largura();

        this.dwt = dados.dwt();

        if (dados.produto() != null) {
            this.produto = dados.produto();
        }

        if (dados.agente() != null) {
            this.agente = dados.agente();
        }

        if (dados.empresa() != null) {
            this.empresa = dados.empresa();
        }
    }

    public void delecaoLogica() {
        this.ativo = false;
    }
}


