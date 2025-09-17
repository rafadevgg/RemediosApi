package com.remedios.rafa.curso.dto;

import com.remedios.rafa.curso.model.RemedioModel;

import java.time.LocalDate;

public record DadosDetalhamentoDto(Long id,
                                   String nome,
                                   Via via,
                                   String lote,
                                   int quantidade,
                                   LocalDate validade,
                                   Laboratorio laboratorio,
                                   Boolean ativo) {

    public DadosDetalhamentoDto(RemedioModel remedio) {
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getQuantidade(),
                remedio.getValidade(),
                remedio.getLaboratorio(),
                remedio.getAtivo()
        );
    }
}
