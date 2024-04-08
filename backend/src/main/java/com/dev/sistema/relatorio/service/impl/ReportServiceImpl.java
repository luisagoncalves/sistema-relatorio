package com.dev.sistema.relatorio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.mapper.ReportIO;
import com.dev.sistema.relatorio.mapper.ReportMapper;
import jakarta.persistence.Converter;
import org.modelmapper.spi.MappingContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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

    private Pageable createPageRequestUsing(int page, int size) {
        return PageRequest.of(page, size);
    }

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
        Pageable pageRequest = createPageRequestUsing(page, pageSize);

        List<Report> reports = repository.findAll();
        int start = (int) pageRequest.getOffset();
        int end = Math.min((start + pageRequest.getPageSize()), reports.size());

        List<Report> pageContent = reports.subList(start, end);
        return new PageImpl<>(pageContent, pageRequest, reports.size());
    }

    @Override
    public ReportDTO getReportById(UUID id) {
        Optional<Report> optionalReport = repository.findById(id);
        Report report = null;
        if (optionalReport.isPresent()) {
            report = optionalReport.get();
        }
        return reportMapper.toDto(report);
    }

    @Override
    @Transactional
    public void updateReport(ReportDTO reportDto, UUID id) {
        Optional<Report> report = repository.findById(id);
        if (report.isPresent()) {
            try {
                Report updatedReport = reportIO.mapTo(reportDto);
                updatedReport.setId(report.get().getId());
                repository.save(updatedReport);
            } catch (Exception e) {
                System.out.println("Error to update report " + report.get().getId());
            }
        }
    }

    @Override
    @Transactional
    public void deleteReportById(UUID id) {
        Optional<Report> report = repository.findById(id);
        if (report.isPresent()) {
            try {
                repository.deleteById(id);
            } catch (Exception e) {
                System.out.println("Error to delete report " + report.get().getId());
            }
        }
    }
}
