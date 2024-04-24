package com.dev.sistema.relatorio.service;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.model.Report;

import java.util.List;

public interface AttachmentService {
    List<Attachment> getAll();
    void save(Attachment attachment);
    void deletById(Integer id);
    List<AttachmentDTO> findByReportId(Integer reportId);
}
