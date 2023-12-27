package com.dev.sistema.relatorio.domain.service;

import java.util.List;
import java.util.Optional;

import com.dev.sistema.relatorio.domain.model.Report;

public interface ReportService {
  public Report save(Report report);
  
  public Optional<Report> getById(Long id);
  
  public List<Report> getAll();

  public void deleteById(Long id);
}
