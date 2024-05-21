package com.dev.sistema.relatorio.resource;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.service.AttachmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attachments")
@CrossOrigin(origins = "http://localhost:3000")
public class AttachmentResource {
    private final AttachmentService service;
    public AttachmentResource(AttachmentService service) {
        this.service = service;
    }
    @GetMapping("/{reportId}")
    public ResponseEntity<List<AttachmentDTO>> getAllAttachmentsByReportId(@PathVariable @Valid UUID reportId) {
        List<AttachmentDTO> attachments = service.findAllByReportId(reportId);
        return ResponseEntity.ok(attachments);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttachment(@PathVariable UUID id){
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
