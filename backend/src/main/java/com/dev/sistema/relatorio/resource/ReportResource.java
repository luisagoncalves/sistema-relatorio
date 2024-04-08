package com.dev.sistema.relatorio.resource;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.dev.sistema.relatorio.dto.ReportDTO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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
    @RequestParam(defaultValue = "") String search,
    @RequestParam(defaultValue = "0") Integer page,
    @RequestParam(defaultValue = "10") Integer pageSize
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
  public ResponseEntity<Void> updateReport(@RequestBody ReportDTO reportDto, @PathVariable UUID id) {
    service.updateReport(reportDto, id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteReport(@PathVariable UUID id) {
    service.deleteReportById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
