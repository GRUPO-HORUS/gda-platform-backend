package com.horustek.gda.infra.utils.reports;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FormatConverter implements Converter<String, ExportFormat> {

    @Override
    public ExportFormat convert(String source) {
        if (source == null)
            return ExportFormat.PDF;
        String upper = source.toUpperCase();
        try {
            return ExportFormat.valueOf(upper);
        } catch (Exception e) {
            return ExportFormat.PDF;
        }
    }

}