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

import com.dev.sistema.relatorio.domain.model.Report;
import com.dev.sistema.relatorio.domain.service.ReportService;

@RestController
@RequestMapping("/reports")
public class ReportController {
  
  private final ReportService service;

  public ReportController(ReportService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<Report> saveReport(@RequestBody Report report){
    Report savedReport = service.save(report);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedReport);
  }

  @GetMapping
  public ResponseEntity<List<Report>> getAllReports(){
    List<Report> allReports = service.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(allReports);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Report> getReportById(@PathVariable Long id){
    Optional<Report> report = service.getById(id);

    if (report.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.status(HttpStatus.OK).body(report.get());
  }

  @PutMapping
  public ResponseEntity<Report> updateReport(@RequestBody Report report){
    Report updatedReport = service.save(report);
    return ResponseEntity.status(HttpStatus.OK).body(updatedReport);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReport(Long id){
    service.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
