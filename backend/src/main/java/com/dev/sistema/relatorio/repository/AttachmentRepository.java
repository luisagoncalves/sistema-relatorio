package com.dev.sistema.relatorio.repository;

import com.dev.sistema.relatorio.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    @Query(value = "SELECT * FROM attachment WHERE attachment.report_id = ?1", nativeQuery = true)
    List<Attachment> findAllByReportId(@Param("reportId") UUID reportId);
}
