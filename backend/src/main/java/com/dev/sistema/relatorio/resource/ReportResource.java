package com.dev.sistema.relatorio.resource;

import com.dev.sistema.relatorio.dto.ReportDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dev.sistema.relatorio.mapper.ReportMapper;
import com.dev.sistema.relatorio.model.Report;
import com.dev.sistema.relatorio.service.ReportService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/reports")
@CrossOrigin(origins = "http://localhost:3000")
public class ReportResource {

  private final ReportService service;
  private final ReportMapper mapper;

  public ReportResource(ReportService service, ReportMapper mapper) {
    this.service = service;
    this.mapper = mapper;
  }

  @PostMapping
  public ResponseEntity<ReportDTO> saveReport(@RequestBody @Valid ReportDTO reportDto) {
    Report savedReport = service.saveReport(reportDto);
    ReportDTO reportResponse = mapper.toDto(savedReport);
    return ResponseEntity.status(HttpStatus.CREATED).body(reportResponse);
  }

  @GetMapping
  public ResponseEntity<Page<Report>> getAllReports(
    @RequestParam(defaultValue = "0") Integer page,
    @RequestParam(defaultValue = "5") Integer pageSize
  ) {
    Page<Report> reportPage = service.getAllReports(page, pageSize);

    return ResponseEntity.ok().body(reportPage);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ReportDTO> getReportById(@PathVariable Integer id) {
    ReportDTO report = service.getReportById(id);
    return ResponseEntity.status(HttpStatus.OK).body(report);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Void> updateReport(@RequestBody @Valid ReportDTO reportDto, @PathVariable Integer id) {
    service.updateReport(reportDto, id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReport(@PathVariable Integer id) {
    service.deleteReportById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
