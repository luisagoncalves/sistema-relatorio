package com.dev.sistema.relatorio.mapper;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.model.Report;

import java.util.List;
import java.util.stream.Collectors;

public interface ReportMapper {
    static Report toEntity(ReportDTO reportDto) {
        return Report.builder()
                .title(reportDto.getTitle())
                .description(reportDto.getDescription())
                .createdAt(reportDto.getCreatedAt())
                .updatedAt(reportDto.getUpdatedAt())
                .build();
    }

    static ReportDTO toDto(Report report) {
        return ReportDTO.builder()
                .id(report.getId())
                .title(report.getTitle())
                .description(report.getDescription())
                .attachments(AttachmentMapper.toDtoList(report.getAttachments()))
                .createdAt(report.getCreatedAt())
                .updatedAt(report.getUpdatedAt())
                .build();
    }

    static List<ReportDTO> toDtoList(List<Report> reports) {
        return reports
                .stream()
                .map(ReportMapper::toDto)
                .collect(Collectors.toList());
    }
}