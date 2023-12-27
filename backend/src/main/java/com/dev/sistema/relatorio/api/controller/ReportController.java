package com.dev.sistema.relatorio.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.sistema.relatorio.api.mapper.ReportMapper;
import com.dev.sistema.relatorio.api.request.ReportRequest;
import com.dev.sistema.relatorio.api.response.ReportResponse;
import com.dev.sistema.relatorio.domain.model.Report;
import com.dev.sistema.relatorio.domain.service.ReportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reports")
public class ReportController {

  private final ReportService service;
  private final ReportMapper mapper;

  public ReportController(ReportService service, ReportMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<ReportResponse> saveReport(@Valid @RequestBody ReportRequest reportRequest) {
    Report report = mapper.toEntity(reportRequest);
    Report savedReport = service.save(report);
    ReportResponse reportResponse = mapper.toResponse(savedReport);
    return ResponseEntity.status(HttpStatus.CREATED).body(reportResponse);
  }

  @GetMapping
  public ResponseEntity<List<ReportResponse>> getAllReports() {
    List<Report> allReports = service.getAll();
    List<ReportResponse> reportsResponses = mapper.toReportResponseList(allReports);
    return ResponseEntity.status(HttpStatus.OK).body(reportsResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReportResponse> getReportById(@PathVariable Long id) {
    Optional<Report> report = service.getById(id);

    if (report.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    ReportResponse reportResponse = mapper.toResponse(report.get());
    return ResponseEntity.status(HttpStatus.OK).body(reportResponse);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateReport(@RequestBody ReportRequest reportRequest, @PathVariable Long id) {
    Report report = mapper.toEntity(reportRequest);
    service.update(report, id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
