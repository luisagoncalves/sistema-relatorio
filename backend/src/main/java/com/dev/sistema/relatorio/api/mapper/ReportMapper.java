package com.dev.sistema.relatorio.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.dev.sistema.relatorio.api.request.ReportRequest;
import com.dev.sistema.relatorio.api.response.ReportResponse;
import com.dev.sistema.relatorio.domain.model.Report;

@Component
public class ReportMapper {
  private final ModelMapper mapper;

  public ReportMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public Report toEntity(ReportRequest reportRequest) {
    return mapper.map(reportRequest, Report.class);
  }

  public ReportResponse toResponse(Report report) {
    return mapper.map(report, ReportResponse.class);
  }

  public List<ReportResponse> toReportResponseList(List<Report> reports) {
    return reports
        .stream()
        .map(this::toResponse)
        .collect(Collectors.toList());
  }
}
