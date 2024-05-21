package com.dev.sistema.relatorio.resource;

import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.sistema.relatorio.model.Report;
import com.dev.sistema.relatorio.service.ReportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/reports")
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<Page<Report>> getAllReports(
            @RequestParam(defaultValue = "search") String search,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer pageSize
    ) {
        Page<Report> reportPage = service.getAllReports(search, page, pageSize);
        return ResponseEntity.ok().body(reportPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable UUID id) {
        ReportDTO report = service.getReportById(id);
        return ResponseEntity.status(HttpStatus.OK).body(report);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateReport(@RequestBody @Valid ReportDTO reportDto, @PathVariable UUID id) {
        service.updateReport(reportDto, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable UUID id) {
        service.deleteReportById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
