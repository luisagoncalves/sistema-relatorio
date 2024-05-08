package com.dev.sistema.relatorio.service.impl;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.mapper.AttachmentMapper;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.repository.AttachmentRepository;
import com.dev.sistema.relatorio.repository.ReportRepository;
import com.dev.sistema.relatorio.service.AttachmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository repository;
    private final ReportRepository reportRepository;
    private final AttachmentMapper mapper;

    public AttachmentServiceImpl(AttachmentRepository repository, ReportRepository reportRepository, AttachmentMapper mapper) {
        this.repository = repository;
        this.reportRepository = reportRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveAttachment(Attachment attachment) {
        repository.save(attachment);
    }

    @Override
    public List<AttachmentDTO> findAllByReportId(UUID reportId) {
        List<Attachment> attachments = repository.findAllByReportId(reportId.toString());
        return mapper.toReportDtoList(attachments);
    }

    @Override
    public List<AttachmentDTO> findAll() {
        List<Attachment> attachments = repository.findAll();
        return mapper.toReportDtoList(attachments);
    }
}

