package com.dev.sistema.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReportDTO {
    private UUID id;
    @NotBlank(message = "O título não pode ser vazio.")
    private String title;
    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;
    private List<AttachmentDTO> attachments;

    public ReportDTO(String title, String description){
        this.title = title;
        this.description = description;
    }
}
