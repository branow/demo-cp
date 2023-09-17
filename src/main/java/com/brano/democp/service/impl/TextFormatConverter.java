package com.brano.democp.service.impl;

import com.brano.democp.entity.auxilary.TextFormat;

import javax.persistence.AttributeConverter;

public class TextFormatConverter implements AttributeConverter<TextFormat, String> {
    @Override
    public String convertToDatabaseColumn(TextFormat textFormat) {
        return null;
    }

    @Override
    public TextFormat convertToEntityAttribute(String s) {
        return null;
    }
}
