package com.remedios.rafa.curso.controller;

import com.remedios.rafa.curso.dto.DadosAtualizarDto;
import com.remedios.rafa.curso.dto.DadosCadastroDto;
import com.remedios.rafa.curso.dto.DadosListagemDto;
import com.remedios.rafa.curso.model.RemedioModel;
import com.remedios.rafa.curso.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/remedios")

public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroDto dados) {
        repository.save(new RemedioModel(dados));
    }

    @GetMapping
    public List<DadosListagemDto> listar() {
        return repository.findAll().stream().map(DadosListagemDto::new).toList();
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizarDto dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);
    }
}
