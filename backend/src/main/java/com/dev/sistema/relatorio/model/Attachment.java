package com.dev.sistema.relatorio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String description;
    private String type;
    @Column(name = "base64", columnDefinition = "LONGVARCHAR")
    private String fileBase64;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "report", referencedColumnName = "id")
    Report report;
}
