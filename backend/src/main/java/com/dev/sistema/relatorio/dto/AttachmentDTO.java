package com.dev.sistema.relatorio.dto;

import com.dev.sistema.relatorio.model.Report;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttachmentDTO {
    private Integer id;
    private UUID reportId;
    private String description;
    private String type;
    private String fileBase64;
}
