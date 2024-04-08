package com.dev.sistema.relatorio.service;

import java.util.Optional;
import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.model.Report;
import org.springframework.data.domain.Page;

public interface ReportService {
  public Report saveReport(ReportDTO reportDto);

  //public void updateReport(ReportDTO reportDto, UUID id);

  public ReportDTO getReportById(UUID id);
  
  public Page<Report> getAllReports(String search, Integer page, Integer pageSize);

  public void deleteReportById(UUID id);
}
