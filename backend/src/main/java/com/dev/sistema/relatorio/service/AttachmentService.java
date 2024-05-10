package com.dev.sistema.relatorio.service;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.model.Attachment;

import java.util.List;
import java.util.UUID;

public interface AttachmentService {
    void saveAttachment(Attachment attachment);
    List<AttachmentDTO> findAllByReportId(UUID reportId);
    void deleteById(Integer id);
}
