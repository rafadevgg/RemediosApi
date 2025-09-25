package com.remedios.rafa.curso.controller;

import com.remedios.rafa.curso.dto.DadosAtualizarDto;
import com.remedios.rafa.curso.dto.DadosCadastroDto;
import com.remedios.rafa.curso.dto.DadosDetalhamentoDto;
import com.remedios.rafa.curso.dto.DadosListagemDto;
import com.remedios.rafa.curso.model.RemedioModel;
import com.remedios.rafa.curso.repository.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")

public class RemedioController {

    @Autowired
    private RemedioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoDto> cadastrar(@RequestBody @Valid DadosCadastroDto dados, UriComponentsBuilder uriBuilder) {
        var remedio = new RemedioModel(dados);

        repository.save(new RemedioModel(dados));

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoDto(remedio));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemDto>> listar() {
        var lista = repository.findAllByAtivoTrue().stream().map(DadosListagemDto::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoDto> atualizar(@RequestBody @Valid DadosAtualizarDto dados) {
        var remedio = repository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoDto(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.inativar();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("reativar/{id}")
    @Transactional
    public ResponseEntity<Void> reativar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);
        remedio.reativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoDto> detalhar(@PathVariable Long id) {
        var remedio = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoDto(remedio));
    }
}
