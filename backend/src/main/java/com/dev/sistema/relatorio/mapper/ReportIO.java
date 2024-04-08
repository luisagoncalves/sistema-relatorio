package com.dev.sistema.relatorio.mapper;


import com.dev.sistema.relatorio.dto.ReportDTO;
import com.dev.sistema.relatorio.model.Report;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("reportIO")
public class ReportIO {
    private final ModelMapper modelMapper;

    final Converter<ReportDTO, Report> reportConverter = new Converter<ReportDTO, Report>() {
        @Override
        public Report convert(MappingContext<ReportDTO, Report> context) {
            ReportDTO reportDto = context.getSource();

            Report reportEntity = new Report();
            reportEntity.setTitle(reportDto.getTitle());
            reportEntity.setDescription(reportDto.getDescription());
            reportEntity.setAttachments(reportDto.getAttachments());
            return reportEntity;
        }
    };

    public ReportIO() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(reportConverter);
    }

    public Report mapTo(ReportDTO reportDto) {
        return this.modelMapper.map(reportDto, Report.class);
    }
}
