package com.dev.sistema.relatorio.mapper;

import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.model.Attachment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttachmentMapper {
    private final ModelMapper mapper;

    public AttachmentMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Attachment toEntity(AttachmentDTO dto){
        return mapper.map(dto, Attachment.class);
    }

    public AttachmentDTO toDto(Attachment entity){
        return mapper.map(entity, AttachmentDTO.class);
    }

    public List<AttachmentDTO> toReportDtoList(List<Attachment> attachments) {
        return attachments
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
