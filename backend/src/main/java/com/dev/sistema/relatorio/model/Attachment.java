package com.dev.sistema.relatorio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Table(name = "attachment")
@Entity
@Data
public class Attachment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(name = "description_base64")
    private String description;
    
    @ManyToOne
    @JoinColumn(name = "report_id")
    private Report report;
}
