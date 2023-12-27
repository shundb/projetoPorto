package com.example.lineporto.application.rest.controllers;

import com.example.lineporto.domain.dtos.DadosAtualizacaoNavio;
import com.example.lineporto.domain.dtos.DadosCadastroNavioDTO;
import com.example.lineporto.domain.dtos.DadosDetalhamentoNavioDTO;
import com.example.lineporto.domain.dtos.DadosListagemNavioDTO;
import com.example.lineporto.domain.entities.Navio.Navio;
import com.example.lineporto.domain.repositories.NavioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("navios")
public class NavioController {

    @Autowired
    private NavioRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemNavioDTO>> listNavios(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(DadosListagemNavioDTO::new);
        return ResponseEntity.ok(page);
    }


    @PostMapping
    @Transactional
    public ResponseEntity postNavio(@RequestBody @Valid DadosCadastroNavioDTO dados, UriComponentsBuilder uriComponentsBuilder) {
        var navio = new Navio(dados);

        repository.save(navio);

        var uri = uriComponentsBuilder.path("navios/{id}").buildAndExpand(navio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoNavioDTO(navio));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity putNavio(@RequestBody @Valid DadosAtualizacaoNavio dados, @PathVariable Long id) {
        var navio = repository.getReferenceById(id);
        navio.atualizarInformacao(dados);

        return ResponseEntity.ok(new DadosDetalhamentoNavioDTO(navio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteNavio(@PathVariable Long id) {
        var navio = repository.getReferenceById(id);
        navio.delecaoLogica();

        return ResponseEntity.noContent().build();
    }
}
//    @GetMapping("/navios/formulario")
//    public String mostrarFormulario (Model model){
//        model.addAttribute("navio", new Navio());
//        return "navio-form.html";
//    }
//
//
//    @PostMapping("/navios/formulario")
//    public String atracarNavio(@ModelAttribute Navio navioInfoClass, Model model) {
//        boolean podeAtracar = atracacaoService.podeAtracar(navioInfoClass);
//
//        if(podeAtracar){
//            model.addAttribute("mensagem", "o navio pode atracar");
//
//        }else {
//            model.addAttribute("mensagem", "o navio não pode atracar: motivo:");
//
//
//        }
//        model.addAttribute("navio", navioInfoClass);
//        return "redirect:/navios/atracar";
//    }
//    @GetMapping("/navios/atracar")
//    public String resultadoAtracacao(Model model){
//        model.addAttribute("navio", new Navio());
//        return "resultado-atracacao.html";
//    }