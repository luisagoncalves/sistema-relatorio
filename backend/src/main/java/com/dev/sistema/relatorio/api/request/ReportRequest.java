package com.dev.sistema.relatorio.api.request;

import java.time.LocalDateTime;
import java.util.List;

import com.dev.sistema.relatorio.domain.model.Attachment;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    @NotBlank(message = "O título do relatório é obrigatório")
    private String title;

    @NotBlank(message = "A descrição do relatório é obrigatória")
    private String description;
    
    private List<Attachment> attachments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
