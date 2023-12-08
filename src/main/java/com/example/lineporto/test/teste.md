<!-- src/main/resources/templates/resultado-atracacao.html -->
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Resultado da Atracação</title>
</head>
<body>
    <h2>Resultado da Atracação</h2>
    <p>th:text = "'nome: ' + ${NavioController.name}" </p>
    <p th:text="${mensagem}"></p>
</body>
</html>


<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Formulario de Navio</title>
</head>

<body>
    <h2>Formulário de Navio</h2>
    <form action="#" th:action="@{/navio/formulario}" method="post" th:object="${navio}">
        <label for="nome">Nome do Navio:</label>
        <input type="text" id="nome" name="nome" th:field="*{nome}" required>

        <label for="empresa">Empresa:</label>
        <input type="text" id="empresa" name="empresa" th:field="*{empresa}" required>
    
        <label for="tipoCarga">Tipo de Carga:</label>
        <input type="text" id="tipoCarga" name="tipoCarga" th:field="*{tipoCarga}" required>
    
        <label for="tamanho">Tamanho do Navio:</label>
        <input type="number" id="tamanho" name="tamanho" th:field="*{tamanho}" required>
    
        <label for="largura">Largura do Navio:</label>
        <input type="number" id="largura" name="largura" th:field="*{largura}" required>
    
        <label for="profundidade">Profundidade do Navio:</label>
        <input type="number" id="profundidade" name="profundidade" th:field="*{profundidade}" required>
    
        <p><input type="submit" value="submit"></p>
    </form>


</body>

</html>

package com.example.lineporto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@Controller

public class LineportoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LineportoApplication.class, args);
	}

}

package com.example.lineporto.Service;

import com.example.lineporto.Navios.NavioInfoClass;

public interface AtracacaoService {
    boolean podeAtracar(NavioInfoClass navioInfoClass);
}

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

package com.example.lineporto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lineporto.Navios.NavioInfoClass;
import com.example.lineporto.Service.AtracacaoService;

@Controller
public class NavioController {

    @Autowired
    private AtracacaoService atracacaoservice;

    @GetMapping("/navios/formulario")
    public String mostrarFormulario (Model model){
        model.addAttribute("navio", new NavioInfoClass());
        return "navio-form.html"; 
    }

    @PostMapping("/navios/formulario")
    public String atracarNavio(@ModelAttribute NavioInfoClass navioInfoClass, Model model) {
        model.addAttribute("navio", new NavioInfoClass());
        return "resultado-atracacao";
    }
}
