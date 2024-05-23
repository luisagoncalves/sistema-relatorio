package com.dev.sistema.relatorio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class ReportDTO {
    private UUID id;
    @NotBlank(message = "The title cannot be blank.")
    private String title;
    @NotBlank(message = "The description cannot be blank.")
    private String description;
    private List<AttachmentDTO> attachments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
