package com.mobest1an.telbot.TelegramBot.config;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Serializer {

    String encode(Object obj);
    <T> T decode(String string, Class<T> clazz) throws JsonProcessingException;
}
