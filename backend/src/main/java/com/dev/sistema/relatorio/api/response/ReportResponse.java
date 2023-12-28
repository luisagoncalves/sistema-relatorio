package com.dev.sistema.relatorio.api.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-ddHH-mm-ss")
    private LocalDateTime createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-ddHH-mm-ss")
    private LocalDateTime updatedAt;
}
