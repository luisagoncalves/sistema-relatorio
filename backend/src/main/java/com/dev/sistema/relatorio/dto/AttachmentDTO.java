package com.dev.sistema.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachmentDTO {
    private UUID id;
    @NotNull
    private UUID reportId;
    @NotBlank
    private String description;
    @NotBlank
    private String type;
    @NotBlank
    private String fileBase64;
}
