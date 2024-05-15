package com.dev.sistema.relatorio.service.impl;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
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
    private final AttachmentMapper mapper;

    public AttachmentServiceImpl(AttachmentRepository repository, AttachmentMapper mapper) {
        this.repository = repository;
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
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}

