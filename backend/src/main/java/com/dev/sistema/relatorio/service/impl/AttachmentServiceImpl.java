package com.dev.sistema.relatorio.service.impl;

import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.repository.AttachmentRepository;
import com.dev.sistema.relatorio.service.AttachmentService;
import org.springframework.stereotype.Service;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository repository;

    public AttachmentServiceImpl(AttachmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Attachment saveAttachment(Attachment attachment) {
        return repository.save(attachment);
    }
}
