package com.dev.sistema.relatorio.service.impl;

import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.mapper.ReportIO;
import com.dev.sistema.relatorio.mapper.ReportMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev.sistema.relatorio.model.Report;
import com.dev.sistema.relatorio.repository.ReportRepository;
import com.dev.sistema.relatorio.service.ReportService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

    private final ReportRepository repository;
    private final ReportMapper reportMapper;
    private final ReportIO reportIO;

    public ReportServiceImpl(ReportRepository repository, ReportMapper reportMapper, ReportIO reportIO) {
        this.repository = repository;
        this.reportMapper = reportMapper;
        this.reportIO = reportIO;
    }

    @Override
    public Report saveReport(ReportDTO reportDto) {
        Report reportEntity = reportMapper.toEntity(reportDto);
        return repository.save(reportEntity);
    }

    @Override
    public Page<Report> getAllReports(String search, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
//        return repository.findAllBySearch(search, pageable);
        return repository.findAll(pageable);
    }

    @Override
    public ReportDTO getReportById(UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException(Logger.getLogger("O relatório não foi encontrado").toString());
        }
        return reportMapper.toDto(reportSearched.get());
    }

    @Override
    @Transactional
    public void updateReport(ReportDTO reportDto, UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException("O relatório não foi encontrado");
        }
        try {
            Report updatedReport = reportIO.mapTo(reportDto);
            updatedReport.setId(reportSearched.get().getId());
            repository.save(updatedReport);
        } catch (RuntimeException e) {
            Logger.getLogger("Erro ao atualizar relatório " + reportSearched.get().getId());
        }
    }

    @Override
    @Transactional
    public void deleteReportById(UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException(Logger.getLogger("O relatório não foi encontrado").toString());
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            Logger.getLogger("Erro ao deletar relatório " + reportSearched.get().getId());
        }
    }
}
