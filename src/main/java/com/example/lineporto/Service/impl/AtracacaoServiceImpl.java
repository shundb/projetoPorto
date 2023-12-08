package com.example.lineporto.Service.impl;

import org.springframework.stereotype.Service;

import com.example.lineporto.Navios.NavioInfoClass;
import com.example.lineporto.Service.AtracacaoService;

@Service
public class AtracacaoServiceImpl implements AtracacaoService {
    @Override
    public boolean podeAtracar(NavioInfoClass navioInfoClass) {
        if (navioInfoClass.getEmpresa().equalsIgnoreCase("Suzano")) {
            return true;
        } else if (navioInfoClass.getTipoCarga().equalsIgnoreCase("Marinha")) {
            return true;
        } else {
            // Define um motivo para rejeitar a solicitação de atracação
            setMotivo("Empresa não autorizada ou tipo de carga não permitido");
            return false;
        }
    }
    
    private String motivo;
    
    public String getMotivo() {
        return motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    

    
}
