package com.dev.sistema.relatorio.repository;

import com.dev.sistema.relatorio.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
