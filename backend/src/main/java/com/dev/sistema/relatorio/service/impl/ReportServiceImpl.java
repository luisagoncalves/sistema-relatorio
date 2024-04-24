package com.dev.sistema.relatorio.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.mapper.ReportIO;
import com.dev.sistema.relatorio.mapper.ReportMapper;
import com.dev.sistema.relatorio.model.Attachment;
import jakarta.persistence.Converter;
import org.jboss.logging.Logger;
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
import org.springframework.web.multipart.MultipartFile;

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
        boolean existsReport = repository.existsById(reportDto.getId());

        if (existsReport) {
            Logger.getLogger("Já existe um relatório com id: " + reportDto.getId());
        }

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
    public ReportDTO getReportById(Integer id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException("O relatório não foi encontrado");
        }
        return reportMapper.toDto(reportSearched.get());
    }

    @Override
    @Transactional
    public void updateReport(ReportDTO reportDto, Integer id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException("O relatório não foi encontrado");
        }
        try {
            Report updatedReport = reportIO.mapTo(reportDto);
            updatedReport.setId(reportSearched.get().getId());
            repository.save(updatedReport);
        } catch (Exception e) {
            System.out.println("Error to update report " + reportSearched.get().getId());
        }
    }

    @Override
    @Transactional
    public void deleteReportById(Integer id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isPresent()) {
            throw new RuntimeException("O relatório não foi encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error to delete report " + reportSearched.get().getId());
        }

    }
}
