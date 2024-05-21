package com.dev.sistema.relatorio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "attachment")
@Entity
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attachment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String description;
    private String type;
    @Column(name = "base64", columnDefinition = "LONGVARCHAR")
    private String fileBase64;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "report", referencedColumnName = "id")
    Report report;
}
