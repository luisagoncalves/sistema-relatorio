package com.dev.sistema.relatorio.service.impl;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.mapper.AttachmentMapper;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.model.Report;
import com.dev.sistema.relatorio.repository.AttachmentRepository;
import com.dev.sistema.relatorio.repository.ReportRepository;
import com.dev.sistema.relatorio.service.AttachmentService;
import jakarta.persistence.Convert;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.*;
import java.util.logging.Logger;

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
    public List<Attachment> getAll() {
        return repository.findAll().stream().toList();
    }

    @Override
    @Transactional
    public void save(Attachment attachment) {
        repository.save(attachment);
    }

    @Override
    @Transactional
    public void deletById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<AttachmentDTO> findByReportId(UUID reportId) {
        Optional<Report> report = reportRepository.findById(reportId);
        List<Attachment> attachments = null;
        if (report.isPresent()) attachments = report.get().getAttachments();
        if (attachments == null) throw new AssertionError();
        return attachments.stream().map(attachment -> {
            AttachmentDTO attachmentDTO = mapper.toDto(attachment);
            attachmentDTO.setFileBase64(attachment.base64());
            attachmentDTO.setReportId(attachment.getReport().getId());
            return attachmentDTO;
        }).toList();
    }
}

//    @Transactional
//    void saveAttachmentsInReport(List<AttachmentDTO> attachments, Report report) throws IOException {
//        if (attachments == null) return;
//        deleteAll(report);
//        if (Paths.get(formatPath(report.getId().toString())).toFile().exists()){
//            Arrays.stream(Objects.requireNonNull(new File(formatPath(report.getId().toString())).listFiles())).forEach(File::delete);
//        }
//        for (AttachmentDTO attachmentDTO : attachments) {
//            boolean isCreated = createPathAndSaveFile(attachmentDTO, report.getId());
//            if (isCreated) {
//                Attachment attachment1 = mapper.toEntity(attachmentDTO);
//                attachment1.setReport(report);
//                save(attachment1);
//            }
//        }
//    }
//
//    private boolean createPathAndSaveFile(AttachmentDTO attachmentDTO, Integer reportId) throws IOException {
//        if (attachmentDTO.getFileBase64() == null || attachmentDTO.getFileBase64().isBlank()){
//            Logger.getLogger("File is empty!");
//        }
//
//        String filename = fileName(reportId, Instant.now());
//
//        var path = formatPath(reportId.toString());
//
//        if(!Paths.get(path).toFile().exists()){
//            try{
//                Files.createDirectories(Paths.get(path));
//            } catch (IOException e) {
//                Logger.getLogger(e.getMessage());
//                throw new IOException(e);
//            }
//        }
//
//        try{
//            byte[] file = Base64.getDecoder().decode(attachmentDTO.getFileBase64());
//            file = Convert.verifyMimeType(file);
//            if(file != null){
//                Files.write(Paths.get(path + "/" + filename), file);
//                attachmentDTO.setPath(path + "/" + filename);
//            } else {
//                return false;
//            }
//        } catch (Exception e){
//            Logger.getLogger(e.getMessage());
//            return false;
//        }
//        return true;
//    }
//
//    private String formatPath(String nameFile) {
//        return path + "/"+nameFile;
//    }
//
//    private String fileName(Integer idDocumento, Instant data) {
//        return idDocumento +"_" + data.toEpochMilli();
//    }
//}
