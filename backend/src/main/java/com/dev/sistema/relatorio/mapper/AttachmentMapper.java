package com.dev.sistema.relatorio.mapper;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.model.Attachment;

import java.util.List;
import java.util.stream.Collectors;

public class AttachmentMapper {
    public static Attachment toEntity(AttachmentDTO dto){
        return Attachment.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .type(dto.getType())
                .fileBase64(dto.getFileBase64())
                .build();
    }

    public static AttachmentDTO toDto(Attachment entity){
        return AttachmentDTO.builder()
                .id(entity.getId())
                .reportId(entity.getReport().getId())
                .description(entity.getDescription())
                .type(entity.getType())
                .fileBase64(entity.getFileBase64())
                .build();
    }

    public static List<AttachmentDTO> toDtoList(List<Attachment> attachments) {
        return attachments
                .stream()
                .map(AttachmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<Attachment> toEntityList(List<AttachmentDTO> dtoList) {
        return dtoList
                .stream()
                .map(AttachmentMapper::toEntity)
                .collect(Collectors.toList());
    }
}
