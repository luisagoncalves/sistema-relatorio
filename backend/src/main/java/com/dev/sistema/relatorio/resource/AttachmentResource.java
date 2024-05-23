package com.dev.sistema.relatorio.resource;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.exception.AttachmentNotFoundException;
import com.dev.sistema.relatorio.exception.GlobalExceptionHandler;
import com.dev.sistema.relatorio.service.AttachmentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attachments")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Attachment", description = "Endpoints da entidade Attachment")
public class AttachmentResource {
    private final AttachmentService service;

    public AttachmentResource(AttachmentService service) {
        this.service = service;
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<?> getAllAttachmentsByReportId(@PathVariable @Valid UUID reportId) {
        try {
            List<AttachmentDTO> attachments = service.findAllByReportId(reportId);
            return ResponseEntity.ok(attachments);
        }  catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttachment(@PathVariable UUID id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok("File deleted.");
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
