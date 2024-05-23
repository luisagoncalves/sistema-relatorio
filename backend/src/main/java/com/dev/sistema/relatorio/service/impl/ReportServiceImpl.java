package com.dev.sistema.relatorio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import com.dev.sistema.relatorio.dto.ReportDTO;
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

            List<Attachment> attachmentList = AttachmentMapper.toEntityList(reportDto.getAttachments());
            attachmentList.forEach(attachment -> {
                attachment.setReport(savedReport);
                attachmentService.saveAttachment(attachment);
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to save report", e);
        }

        return savedReport;
    }

    @Override
    public Page<Report> getAllReports(String search, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Report> reports;
        try {
            if(search != null){
                reports = repository.findAllBySearch(search, pageable);
            } else {
                reports = repository.findAll(pageable);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return reports;
    }

    @Override
    public ReportDTO getReportById(UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException("Failed to find report.");
        }
        return ReportMapper.toDto(reportSearched.get());
    }

    @Override
    @Transactional
    public void updateReport(ReportDTO reportDto, UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException("Failed to find report.");
        }

        Report updatedReport = ReportMapper.toEntity(reportDto);
        updatedReport.setId(reportSearched.get().getId());
        updatedReport.setCreatedAt(reportSearched.get().getCreatedAt());
        try {
            repository.save(updatedReport);

            List<Attachment> attachmentList = AttachmentMapper.toEntityList(reportDto.getAttachments());
            attachmentList.forEach(attachment -> {
                if (attachment.getId() == null) {
                    attachment.setReport(updatedReport);
                    attachmentService.saveAttachment(attachment);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to update report.");
        }
    }

    @Override
    @Transactional
    public void deleteReportById(UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            Logger.getLogger("Failed to find report");
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            reportSearched.ifPresent(report -> Logger.getLogger("Failed to delete report."));
        }
    }
}
