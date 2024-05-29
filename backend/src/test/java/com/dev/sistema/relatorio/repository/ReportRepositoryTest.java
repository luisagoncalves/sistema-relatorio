package com.dev.sistema.relatorio.repository;

import com.dev.sistema.relatorio.model.Report;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ReportRepositoryTest {

    @Autowired
    private ReportRepository repository;

    Report reportSaved;

    @BeforeEach
    void setUp() {
        reportSaved = Report.builder()
                .title("Test do título")
                .description("Realizando teste do report.")
                .attachments(null)
                .build();

        repository.save(reportSaved);

        assertNotNull(reportSaved);
    }

    @Test
    void testGivenReportObject_whenSave_thenReturnSavedReport() {
        assertNotNull(reportSaved.getId());
    }

    @Test
    void testGivenReportList_whenFindAll_thenReturnReportList() {
        List<Report> reportList = repository.findAll();

        assertNotNull(reportList);
        assertEquals(1, reportList.size());
    }

    @Test
    void testGivenReportObject_whenFindById_thenReturnReportObject() {
        Optional<Report> reportSearched = repository.findById(reportSaved.getId());

        assertTrue(reportSearched.isPresent());
        assertEquals(reportSearched.get().getId(), reportSaved.getId(),
                "The ID of the searched report must be the same as that of the previously saved report.");
    }

    @Test
    void testGivenReportObject_whenUpdateReportTitle_thenReturnUpdatedReportTitle() {
        Optional<Report> reportSearched = repository.findById(reportSaved.getId());

        assertTrue(reportSearched.isPresent());

        reportSaved.setTitle("Atualização do título do teste");

        Report updatedReport = repository.save(reportSaved);
        assertNotEquals("Teste do título", updatedReport.getTitle(),
                "The title of the updated report cannot be the same as that of the previously saved report.");
    }

    @Test
    void testGivenReportObject_whenUpdateReportDescription_thenReturnUpdatedReportDescription() {
        Optional<Report> reportSearched = repository.findById(reportSaved.getId());

        assertTrue(reportSearched.isPresent());

        reportSaved.setDescription("Atualização da descrição do report.");

        Report updatedReport = repository.save(reportSaved);
        assertNotEquals("Realizando teste do report.", updatedReport.getDescription(),
                "The title of the updated report cannot be the same as that of the previously saved report.");
    }

    @Test
    void testGivenReportObject_whenDeleteReportById_thenReturnVoid() {
        repository.deleteById(reportSaved.getId());

        Optional<Report> reportSearched = repository.findById(reportSaved.getId());

        assertTrue(reportSearched.isEmpty());
    }

    @Test
    void testGivenReportTitleOrDescription_whenFindByTitleOrDescription_thenReturnListReport() {
        Pageable pageable = PageRequest.of(0, 5);

        Page<Report> page = repository.findAllBySearch("teste", pageable);

        assertEquals(1, page.getContent().size(),
                "The size of the content page must be the same as the quantity of report(s) found with the searched word(s).");
    }
}