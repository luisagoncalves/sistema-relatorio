package br.dev.luisagoncalves.sisrelatorio.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("relatorios")
public record Relatorio(
    //TODO: Verificar a tipagem adequada para o atributos: 'descricao' e 'anexos'
    @Id Long id, String titulo, TipoRelatorio tipo, String descricao, String anexos
) {
}
