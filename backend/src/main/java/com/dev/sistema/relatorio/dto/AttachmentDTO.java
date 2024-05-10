package com.dev.sistema.relatorio.dto;

import com.dev.sistema.relatorio.model.Report;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDTO {
    @NotNull
    private Integer id;
    @NotNull
    private UUID reportId;
    @NotBlank
    private String description;
    @NotBlank
    private String type;
    @NotBlank
    private String fileBase64;
}
