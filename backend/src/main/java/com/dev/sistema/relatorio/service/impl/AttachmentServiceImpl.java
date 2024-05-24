package com.dev.sistema.relatorio.service.impl;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.exception.AttachmentNoContentException;
import com.dev.sistema.relatorio.exception.AttachmentNotFoundException;
import com.dev.sistema.relatorio.exception.ReportNotFoundException;
import com.dev.sistema.relatorio.mapper.AttachmentMapper;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.repository.AttachmentRepository;
import com.dev.sistema.relatorio.repository.ReportRepository;
import com.dev.sistema.relatorio.service.AttachmentService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository repository;
    private final ReportRepository reportRepository;

    public AttachmentServiceImpl(AttachmentRepository repository, ReportRepository reportRepository) {
        this.repository = repository;
        this.reportRepository = reportRepository;
    }

    @Override
    public void saveAttachment(Attachment attachment) {
        repository.save(attachment);
    }

    @Override
    public List<AttachmentDTO> findAllByReportId(UUID reportId) {
        if (!reportRepository.existsById(reportId)){
            throw new ReportNotFoundException("No report found with id " + reportId);
        }
        try {
            List<Attachment> attachments = repository.findAllByReportId(reportId);
            return AttachmentMapper.toDtoList(attachments);
        } catch (AttachmentNoContentException exception) {
            throw new AttachmentNoContentException("Failed to find attachments for the report id " + reportId + ".");
        }
    }

    @Override
    @Transactional
    public void deleteById(UUID id) {
        if (!repository.existsById(id)) {
            throw new AttachmentNotFoundException("No attachment found with id " + id + ".");
        }
        repository.deleteById(id);
    }
}

