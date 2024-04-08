package com.dev.sistema.relatorio.dto;

import com.dev.sistema.relatorio.model.Attachment;
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
    private String title;
    private String description;
    private List<Attachment> attachments;
}
