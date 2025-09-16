package com.remedios.rafa.curso.dto;

import com.remedios.rafa.curso.model.RemedioModel;

import java.time.LocalDate;

public record DadosListagemDto(Long id,
                               String nome,
                               Via via,
                               String lote,
                               Laboratorio laboratorio,
                               LocalDate validade) {

    public DadosListagemDto(RemedioModel remedio) {
        this(remedio.getId() ,remedio.getNome(), remedio.getVia(), remedio.getLote(), remedio.getLaboratorio(), remedio.getValidade());
    }
}
