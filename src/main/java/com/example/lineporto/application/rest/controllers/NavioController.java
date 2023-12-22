package com.example.lineporto.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lineporto.domain.entity.Navio.NavioInfoClass;
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
        boolean podeAtracar = atracacaoservice.podeAtracar(navioInfoClass);

        if(podeAtracar){
            model.addAttribute("mensagem", "o navio pode atracar");

        }else {
            model.addAttribute("mensagem", "o navio não pode atracar: motivo:"); 


        }
        model.addAttribute("navio", navioInfoClass);
        return "redirect:/navios/atracar";
    }
    @GetMapping("/navios/atracar")
    public String resultadoAtracacao(Model model){
        model.addAttribute("navio", new NavioInfoClass());
        return "resultado-atracacao.html";
    }
}
