package com.dev.sistema.relatorio.service.impl;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.exception.AttachmentNoContentException;
import com.dev.sistema.relatorio.exception.AttachmentNotFoundException;
import com.dev.sistema.relatorio.mapper.AttachmentMapper;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.repository.AttachmentRepository;
import com.dev.sistema.relatorio.service.AttachmentService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository repository;

    public AttachmentServiceImpl(AttachmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAttachment(Attachment attachment) {
        repository.save(attachment);
    }

    @Override
    public List<AttachmentDTO> findAllByReportId(UUID reportId) {
        List<Attachment> attachments = repository.findAllByReportId(reportId);
        if (attachments.isEmpty()) {
            throw new AttachmentNoContentException("No attachments found for the report id " + reportId + ".");
        }
        return AttachmentMapper.toDtoList(attachments);
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

