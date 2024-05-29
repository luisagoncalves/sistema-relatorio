package com.dev.sistema.relatorio.repository;

import com.dev.sistema.relatorio.model.Attachment;
import com.dev.sistema.relatorio.model.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AttachmentRepositoryTest {

    @Autowired
    private AttachmentRepository repository;
    @Autowired
    private ReportRepository reportRepository;
    String base64 = "VEVTVEUgQkFTRSA2NA==";
    Report reportSaved;
    private Attachment attachmentSaved;

    @BeforeEach
    void setUp() {
        attachmentSaved = Attachment.builder()
                .description("Exemplo.txt")
                .fileBase64(base64)
                .type("text/plain")
                .build();

        reportSaved = Report.builder()
                .attachments(List.of(attachmentSaved))
                .build();

        reportRepository.save(reportSaved);

        assertNotNull(reportSaved.getId());
    }

    @Test
    void testGivenAttachmentObject_whenSave_thenReturnSavedAttachment() {
        assertNotNull(attachmentSaved.getId());
    }

    @Test
    void testGivenAttachmentList_whenFindAll_thenReturnAttachmentList() {
        List<Attachment> attachmentList = repository.findAll();

        assertNotNull(attachmentList);
        assertEquals(1, attachmentList.size());
    }

    @Test
    void testGivenAttachmentId_WhenDeleteById_thenReturnVoid() {
        repository.deleteById(attachmentSaved.getId());

        Optional<Attachment> attachmentSearched = repository.findById(attachmentSaved.getId());

        assertTrue(attachmentSearched.isEmpty());
    }
}