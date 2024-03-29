package com.dev.sistema.relatorio.domain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dev.sistema.relatorio.domain.model.Report;
import com.dev.sistema.relatorio.domain.repository.ReportRepository;
import com.dev.sistema.relatorio.domain.service.ReportService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {

  private final ReportRepository repository;

  public ReportServiceImpl(ReportRepository repository) {
    this.repository = repository;
  }

  @Override
  public Report save(Report report) {
    return repository.save(report);
  }

  @Override
  public void update(Report report, Long id) {
    Optional<Report> updatedReport = repository.findById(id);
    updatedReport.get().setId(id);
    updatedReport.get().setTitle(report.getTitle());
    updatedReport.get().setDescription(report.getDescription());
    updatedReport.get().setAttachments(report.getAttachments());
    updatedReport.get().setUpdatedAt(report.getUpdatedAt());

    repository.save(updatedReport.get());
  }

  @Override
  public Optional<Report> getById(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Report> getAll() {
    return repository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void deleteAll() {
    repository.deleteAll();
  }
}
