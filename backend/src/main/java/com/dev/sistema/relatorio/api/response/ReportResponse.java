package com.dev.sistema.relatorio.api.response;

import java.time.OffsetDateTime;
import java.util.List;

import com.dev.sistema.relatorio.domain.model.Attachment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReportResponse {
    private Long id;
    private String title;
    private String description;
    private List<Attachment> attachments;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
