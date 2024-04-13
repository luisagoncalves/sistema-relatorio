package com.dev.sistema.relatorio.service;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.model.Report;
import org.springframework.data.domain.Page;

public interface ReportService {
    public Report saveReport(ReportDTO reportDto);

    public void updateReport(ReportDTO reportDto, Integer id);

    public ReportDTO getReportById(Integer id);

    public Page<Report> getAllReports(Integer page, Integer pageSize);

    public void deleteReportById(Integer id);
}
