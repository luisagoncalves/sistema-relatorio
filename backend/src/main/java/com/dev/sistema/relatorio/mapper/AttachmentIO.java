package com.dev.sistema.relatorio.mapper;


import com.dev.sistema.relatorio.dto.AttachmentDTO;
import com.dev.sistema.relatorio.model.Attachment;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("attachmentIO")
public class AttachmentIO {
    private final ModelMapper modelMapper;

    final Converter<AttachmentDTO, Attachment> attachmentConverter = new Converter<AttachmentDTO, Attachment>() {
        @Override
        public Attachment convert(MappingContext<AttachmentDTO, Attachment> context) {
            AttachmentDTO attachmentDto = context.getSource();

            Attachment attachmentEntity = new Attachment();
            attachmentEntity.setTitle(attachmentDto.getTitle());
            attachmentEntity.setPath(attachmentDto.getPath());

            return attachmentEntity;
        }
    };

    public AttachmentIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(attachmentConverter);
    }

    public Attachment mapTo(AttachmentDTO attachmentDto) {
        return this.modelMapper.map(attachmentDto, Attachment.class);
    }
}
