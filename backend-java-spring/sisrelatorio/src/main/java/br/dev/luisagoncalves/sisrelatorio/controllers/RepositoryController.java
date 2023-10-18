package br.dev.luisagoncalves.sisrelatorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.luisagoncalves.sisrelatorio.models.Relatorio;
import br.dev.luisagoncalves.sisrelatorio.repositories.RelatorioRepository;

@RestController
@RequestMapping("/relatorios")
public class RepositoryController {
    
    @Autowired
    RelatorioRepository repository;

    @PostMapping
    Relatorio create(@RequestBody Relatorio relatorio){
        return repository.save(relatorio);
    }

    @GetMapping
    Iterable<Relatorio> list(){
        return repository.findAll();
    }
}
