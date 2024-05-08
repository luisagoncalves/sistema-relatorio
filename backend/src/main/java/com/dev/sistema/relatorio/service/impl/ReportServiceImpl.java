package com.dev.sistema.relatorio.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.mapper.AttachmentMapper;
import com.dev.sistema.relatorio.mapper.ReportIO;
import com.dev.sistema.relatorio.mapper.ReportMapper;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.service.AttachmentService;
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
    private final ReportIO reportIO;
    private final ReportMapper mapper;
    private final AttachmentMapper attachmentMapper;
    private final AttachmentService attachmentService;

    public ReportServiceImpl(ReportRepository repository, ReportIO reportIO, ReportMapper mapper, AttachmentMapper attachmentMapper, AttachmentService attachmentService) {
        this.repository = repository;
        this.reportIO = reportIO;
        this.mapper = mapper;
        this.attachmentMapper = attachmentMapper;
        this.attachmentService = attachmentService;
    }

    @Override
    public Report saveReport(ReportDTO reportDto) {
        Report reportEntity = mapper.toEntity(reportDto);
        List<AttachmentDTO> attachmentDTOList = reportDto.getAttachments();
        for (AttachmentDTO dto : attachmentDTOList){
            Attachment attachment = attachmentMapper.toEntity(dto);
            attachment.setReport(reportEntity);
            attachmentService.saveAttachment(attachment);
        }
        return repository.save(reportEntity);
    }

    @Override
    public Page<Report> getAllReports(String search, Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return repository.findAll(pageable);
    }

    @Override
    public ReportDTO getReportById(UUID id) {
        Optional<Report> reportSearched = repository.findById(id);
        if (reportSearched.isEmpty()) {
            throw new RuntimeException(Logger.getLogger("O relatório não foi encontrado").toString());
        }
        //return mapper.toDto(reportSearched.get());
        return mapper.toDto(reportSearched.get());
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
            Logger.getLogger("O relatório não foi encontrado");
        }
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            Logger.getLogger("Erro ao deletar relatório " + reportSearched.get().getId());
        }
    }
}
