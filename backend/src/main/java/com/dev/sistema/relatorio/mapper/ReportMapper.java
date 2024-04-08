package com.dev.sistema.relatorio.mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.dev.sistema.relatorio.dto.ReportDTO;
import org.mapstruct.MappingTarget;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.dev.sistema.relatorio.model.Report;

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
