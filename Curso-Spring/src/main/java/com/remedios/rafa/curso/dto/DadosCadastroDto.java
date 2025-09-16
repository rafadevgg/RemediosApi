package com.remedios.rafa.curso.dto;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroDto(@NotBlank(message = "É obrigatório conter o nome do medicamento!")
                               String nome,
                               @Enumerated
                               Via via,
                               @NotBlank(message = "É obrigatório conter o número de lote do medicamento...")
                               String lote,
                               @Min(value = 1, message = "A quantidade do medicamento tem que ser pelo menos 1...")
                               int quantidade,
                               @Future(message = "A data de validade não pode ser datas passadas/antigas!")
                               LocalDate validade,
                               @Enumerated
                               Laboratorio laboratorio) {
}
