package com.remedios.rafa.curso.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarDto(@NotNull(message = "Para atualizar alguma informação do remédio, é preciso conter um ID!")
                                Long id,
                                String nome,
                                Via via,
                                Laboratorio laboratorio) {
}
