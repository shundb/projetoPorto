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

    @GetMapping( value = "/navios/formulario")
    public String mostrarFormulario(Model model) {
      model.addAttribute("navio", new NavioInfoClass());
      return "navio-form";
    }

    @PostMapping("/navios/atracar")
    public String atracarNavio(@ModelAttribute NavioInfoClass navioInfoClass, Model model){
        if(atracacaoservice.podeAtracar(navioInfoClass)){
            model.addAttribute("mensagem", "navio pode atracar");

        }else{
            model.addAttribute("mensagem", "navio não pode atracar");
        }
        return "resultado-atracacao";
    }
}
