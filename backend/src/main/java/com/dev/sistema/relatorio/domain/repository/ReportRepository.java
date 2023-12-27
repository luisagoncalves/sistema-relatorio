package com.dev.sistema.relatorio.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.sistema.relatorio.domain.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long>{
  
}
