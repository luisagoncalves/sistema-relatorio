package com.dev.sistema.relatorio.dto;

import com.dev.sistema.relatorio.model.Attachment;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDTO {
    private Integer id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private List<Attachment> attachments;
}
