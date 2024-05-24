package com.dev.sistema.relatorio.service;

import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.model.Report;
import org.springframework.data.domain.Page;

public interface ReportService {
    Report saveReport(ReportDTO reportDto);

    void updateReport(ReportDTO reportDto, UUID id);

    ReportDTO getReportById(UUID id);

    Page<ReportDTO> getAllReports(String search, Integer page, Integer pageSize);

    void deleteReportById(UUID id);
}
