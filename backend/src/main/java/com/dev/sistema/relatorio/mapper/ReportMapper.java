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
                .build();
    }

    static ReportDTO toDto(Report report) {
        return ReportDTO.builder()
                .id(report.getId())
                .title(report.getTitle())
                .description(report.getDescription())
                .attachments(AttachmentMapper.toDtoList(report.getAttachments()))
                .build();
    }

    static List<ReportDTO> toDtoList(List<Report> reports) {
        return reports
                .stream()
                .map(ReportMapper::toDto)
                .collect(Collectors.toList());
    }
}