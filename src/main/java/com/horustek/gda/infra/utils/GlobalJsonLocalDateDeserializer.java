package com.horustek.gda.infra.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class GlobalJsonLocalDateDeserializer extends JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if (jp.getCurrentTokenId() == JsonTokenId.ID_STRING) {
            try {
                return LocalDate.parse(jp.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
            } catch (DateTimeParseException e) {
                return LocalDate.parse(jp.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        }
        return null;
    }
}

