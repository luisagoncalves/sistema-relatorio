package com.dev.sistema.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private UUID id;
    @NotBlank(message = "O título não pode ser vazio.")
    private String title;
    @NotBlank(message = "A descrição não pode ser vazia.")
    private String description;
    private List<AttachmentDTO> attachments;
}
