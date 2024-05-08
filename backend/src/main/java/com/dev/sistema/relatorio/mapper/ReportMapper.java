package com.dev.sistema.relatorio.mapper;

import com.dev.sistema.relatorio.dto.ReportDTO;

import com.dev.sistema.relatorio.model.Report;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {
    private final ModelMapper mapper;

    public ReportMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Report toEntity(ReportDTO reportDto) {
        return mapper.map(reportDto, Report.class);
    }

    public ReportDTO toDto(Report report) {
        return mapper.map(report, ReportDTO.class);
    }

    public List<ReportDTO> toReportDtoList(List<Report> reports) {
        return reports
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}