package com.remedios.rafa.curso.model;

import com.remedios.rafa.curso.dto.DadosAtualizarDto;
import com.remedios.rafa.curso.dto.DadosCadastroDto;
import com.remedios.rafa.curso.dto.Laboratorio;
import com.remedios.rafa.curso.dto.Via;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Table(name = "Remedios")
@Entity(name = "Remedios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class RemedioModel {

    public RemedioModel(DadosCadastroDto dados) {
        this.nome=dados.nome();
        this.via=dados.via();
        this.lote=dados.lote();
        this.quantidade=dados.quantidade();
        this.validade=dados.validade();
        this.laboratorio=dados.laboratorio();
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;

    private int quantidade;

    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    public void atualizarInformacoes(@Valid DadosAtualizarDto dados) {

        if(dados.nome() != null) {
            this.nome = dados.nome();
        }
        if(dados.via() != null) {
            this.via = dados.via();
        }
        if(dados.laboratorio() != null) {
            this.laboratorio = dados.laboratorio();
        }
    }
}
