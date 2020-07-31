package com.horustek.gda.infra.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JsonUtils {

    public static ObjectMapper getObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        // Registering Hibernate4Module to support lazy objects
        Hibernate5Module hibModule = new Hibernate5Module();
        hibModule.disable(Hibernate5Module.Feature.USE_TRANSIENT_ANNOTATION);
        objectMapper.registerModule(hibModule);
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        //Support for Java 8 DateTime API
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        SimpleModule module = new SimpleModule("", Version.unknownVersion());
        module.addSerializer(LocalDate.class, new GlobalJsonLocalDateSerializer());
        module.addDeserializer(LocalDate.class, new GlobalJsonLocalDateDeserializer());
        module.addSerializer(LocalDateTime.class, new GlobalJsonLocalDateTimeSerializer());
        module.addDeserializer(LocalDateTime.class, new GlobalJsonLocalDateTimeDeserializer());
        module.addSerializer(LocalTime.class, new GlobalJsonLocalTimeSerializer());
        module.addDeserializer(LocalTime.class, new GlobalJsonLocalTimeDeserializer());
        module.addSerializer(Number.class, new GlobalJsonNumberSerializer());
        objectMapper.registerModule(module);
        return objectMapper;
    }

    public static <T> String toJSON(T obj) throws JsonProcessingException {
        return JsonUtils.getObjectMapper().writeValueAsString(obj);
    }

    public static <T> void toJSON(T obj, File outputFile) throws Exception {
        JsonUtils.getObjectMapper().writeValue(outputFile, obj);
    }

    public static <T extends Object> T fromJSON(String json, Class<T> _class) throws Exception {
        return JsonUtils.getObjectMapper().readValue(json, _class);
    }

    public static <T extends Serializable> T fromJSON(File jsonFile, Class<T> _class) throws Exception {
        return JsonUtils.getObjectMapper().readValue(jsonFile, _class);
    }

}
