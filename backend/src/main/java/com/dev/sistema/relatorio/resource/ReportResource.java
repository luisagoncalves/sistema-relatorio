package com.dev.sistema.relatorio.resource;

import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.exception.ReportFormInvalidFieldsException;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.dev.sistema.relatorio.model.Report;
import com.dev.sistema.relatorio.service.ReportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Report", description = "Endpoints da entidade Report")
public class ReportResource {
    private final ReportService service;

    public ReportResource(ReportService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Report> saveReport(@RequestBody @Valid ReportDTO reportDto) {
        Report savedReport = service.saveReport(reportDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedReport);
    }

    @GetMapping
    public ResponseEntity<Page<ReportDTO>> getAllReports(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer pageSize
    ) {
        Page<ReportDTO> reportPage = service.getAllReports(search, page, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(reportPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable UUID id) {
        ReportDTO report = service.getReportById(id);
        return ResponseEntity.status(HttpStatus.OK).body(report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReport(@RequestBody @Valid ReportDTO reportDto, @PathVariable UUID id) {
        service.updateReport(reportDto, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReport(@PathVariable UUID id) {
        service.deleteReportById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
