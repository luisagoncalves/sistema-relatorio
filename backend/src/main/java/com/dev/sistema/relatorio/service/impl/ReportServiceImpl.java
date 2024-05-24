package com.dev.sistema.relatorio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.exception.ReportFormInvalidFieldsException;
import com.dev.sistema.relatorio.exception.ReportNoContentException;
import com.dev.sistema.relatorio.exception.ReportNotFoundException;
import com.dev.sistema.relatorio.mapper.AttachmentMapper;
import com.dev.sistema.relatorio.mapper.ReportMapper;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.service.AttachmentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dev.sistema.relatorio.model.Report;
import com.dev.sistema.relatorio.repository.ReportRepository;
import com.dev.sistema.relatorio.service.ReportService;
import jakarta.transaction.Transactional;

@Service
class ReportServiceImpl implements ReportService {
    private final ReportRepository repository;
    private final AttachmentService attachmentService;

    public ReportServiceImpl(ReportRepository repository, AttachmentService attachmentService) {
        this.repository = repository;
        this.attachmentService = attachmentService;
    }

    @Override
    public Report saveReport(@Valid ReportDTO reportDto) {
        Report reportEntity = ReportMapper.toEntity(reportDto);
        Report savedReport;
        try {
            savedReport = repository.save(reportEntity);

            reportDto.getAttachments()
                    .stream()
                    .map(AttachmentMapper::toEntity)
                    .filter(attachment -> attachment.getId() == null)
                    .forEach(attachment -> {
                        attachment.setReport(savedReport);
                        attachmentService.saveAttachment(attachment);
                    });
        } catch (ReportFormInvalidFieldsException exception) {
            throw new ReportFormInvalidFieldsException();
        }

        return savedReport;
    }

    @Override
    public Page<ReportDTO> getAllReports(String search, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Report> reports;
        try {
            if (search != null) {
                reports = repository.findAllBySearch(search, pageable);
            } else {
                reports = repository.findAll(pageable);
            }
        } catch (ReportNoContentException exception) {
            throw new ReportNoContentException("Failed to list reports.");
        }

        return reports.map(ReportMapper::toDto);
    }

    @Override
    public ReportDTO getReportById(UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new ReportNotFoundException("Failed to find report with id " + id);
        }
        return ReportMapper.toDto(reportSearched.get());
    }

    @Override
    @Transactional
    public void updateReport(ReportDTO reportDto, UUID id) {
        Report reportSearched = repository.findById(id).orElseThrow(() -> new ReportNotFoundException("Failed to find report."));

        Report updatedReport = ReportMapper.toEntity(reportDto);
        updatedReport.setId(reportSearched.getId());
        updatedReport.setCreatedAt(reportSearched.getCreatedAt());
        try {
            repository.save(updatedReport);

            reportDto.getAttachments()
                    .stream()
                    .map(AttachmentMapper::toEntity)
                    .filter(attachment -> attachment.getId() == null)
                    .forEach(attachment -> {
                        attachment.setReport(updatedReport);
                        attachmentService.saveAttachment(attachment);
                    });
        } catch (ReportNotFoundException e) {
            throw new ReportNotFoundException("Failed to update report.");
        }
    }

    @Override
    @Transactional
    public void deleteReportById(UUID id) {
        if (!repository.existsById(id)) {
            throw new ReportNotFoundException("Failed to find report.");
        }
        repository.deleteById(id);
    }
}
