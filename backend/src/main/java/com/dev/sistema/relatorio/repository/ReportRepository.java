package com.dev.sistema.relatorio.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.sistema.relatorio.model.Report;

import java.util.UUID;

@Repository
public interface ReportRepository extends JpaRepository<Report, UUID>{
    @Query("SELECT 'r' FROM Report WHERE 'r.title' LIKE :search OR 'r.description' LIKE :search")
    Page<Report> findAllBySearch(@Param("search") String search, Pageable pageable);
}
