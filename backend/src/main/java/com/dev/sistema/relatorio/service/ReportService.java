package com.dev.sistema.relatorio.service;

import java.util.Optional;
import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.model.Report;
import org.springframework.data.domain.Page;

public interface ReportService {
    Report saveReport(ReportDTO reportDto);

    void updateReport(ReportDTO reportDto, Integer id);

    ReportDTO getReportById(Integer id);

    Page<Report> getAllReports(String search, Integer page, Integer pageSize);

    void deleteReportById(Integer id);
}
