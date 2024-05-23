package com.dev.sistema.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
public class AttachmentDTO {
    private UUID id;
    @NotNull(message = "The report id cannot be null.")
    private UUID reportId;
    @NotBlank(message = "The description cannot be blank.")
    private String description;
    private String type;
    @NotBlank(message = "The description cannot be blank.")
    private String fileBase64;
}
