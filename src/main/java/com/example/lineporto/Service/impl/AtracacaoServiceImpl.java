package com.example.lineporto.Service.impl;

import org.springframework.stereotype.Service;

import com.example.lineporto.domain.entities.Navio.Navio;
import com.example.lineporto.Service.AtracacaoService;
@Service
public class AtracacaoServiceImpl implements AtracacaoService {
    private String motivo;

    @Override
    public boolean podeAtracar(Navio navioInfoClass) {
        if (navioInfoClass.getEmpresa().equalsIgnoreCase("Suzano")) {
            return true;
        } else if (navioInfoClass.getProduto().equalsIgnoreCase("Marinha")) {
            return true;
        } else {
            setMotivo("Empresa não autorizada ou tipo de carga não permitido");
            return false;
        }
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}
