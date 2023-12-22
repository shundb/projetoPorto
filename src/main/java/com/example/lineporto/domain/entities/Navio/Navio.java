package com.example.lineporto.domain.entities.Navio;


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

    public Navio(DadosCadastroNavioDTO dados) {
        this.imo = dados.imo();
        this.nome = dados.nome();
        this.comprimento = dados.comprimento();
        this.largura = dados.largura();
        this.dwt = dados.dwt();
        this.produto = dados.produto();
        this.agente = dados.agente();
        this.empresa = dados.empresa();
    }
}


