package com.dev.sistema.relatorio.resource;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.service.AttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/attachments")
@CrossOrigin(origins = "http://localhost:3000")
public class AttachmentResource {
    private final AttachmentService service;
    public AttachmentResource(AttachmentService service) {
        this.service = service;
    }
    @GetMapping("/{reportId}")
    public ResponseEntity<List<AttachmentDTO>> getAllAttachmentsByReportId(@PathVariable UUID reportId) {
        List<AttachmentDTO> attachments = service.findAllByReportId(reportId);
        return ResponseEntity.ok(attachments);
    }
    @GetMapping
    public ResponseEntity<List<AttachmentDTO>> getAllAttachments(){
        List<AttachmentDTO> attachments = service.findAll();
        return ResponseEntity.ok(attachments);
    }
}
