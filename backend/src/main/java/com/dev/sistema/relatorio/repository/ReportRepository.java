package com.dev.sistema.relatorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.sistema.relatorio.model.Report;

import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, UUID>{

}
