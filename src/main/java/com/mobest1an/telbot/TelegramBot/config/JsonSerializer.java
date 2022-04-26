package com.mobest1an.telbot.TelegramBot.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerializer implements Serializer {
    static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Encode instance as JSON
     *
     * @param obj instance
     * @return JSON
     */
    public String encode(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            return obj.toString();
        }
    }

    public <T> T decode(String json, Class<T> clazz) throws JsonProcessingException {
        return mapper.readValue(json, clazz);
    }
}
