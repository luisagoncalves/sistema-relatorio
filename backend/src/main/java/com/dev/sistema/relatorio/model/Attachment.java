package com.dev.sistema.relatorio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.File;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;
import java.util.logging.Logger;

@Table(name = "attachment")
@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Attachment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String type;
    private String path;
    private String fileBase64;
    @ManyToOne
    @JoinColumn(name = "report", nullable = false, referencedColumnName = "id")
    private Report report;

    public String base64(){
        try {
            File file = new File(URLDecoder.decode(path, "UTF-8"));
            byte[] fileContent = Files.readAllBytes(file.toPath());
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (Exception e){
            Logger.getLogger("Fail to generate base64.");
        }
        return null;
    }
}
