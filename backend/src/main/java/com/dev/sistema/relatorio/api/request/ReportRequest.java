package com.dev.sistema.relatorio.api.request;

import java.time.LocalDateTime;
import java.util.List;

import com.dev.sistema.relatorio.domain.model.Attachment;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportRequest {
    @NotBlank(message = "The title of the report is mandatory.")
    private String title;

    @NotBlank(message = "The description of the report is mandatory.")
    private String description;
    
    private List<Attachment> attachments;

    @NotNull
    @Future
    private LocalDateTime createdAt;
    
    @NotNull
    @Future
    private LocalDateTime updatedAt;
}
