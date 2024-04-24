package com.dev.sistema.relatorio.repository;

import com.dev.sistema.relatorio.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
    Attachment findByTitle(String title);
}
