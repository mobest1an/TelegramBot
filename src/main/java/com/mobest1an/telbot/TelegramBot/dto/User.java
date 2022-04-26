package com.mobest1an.telbot.TelegramBot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {

    @JsonProperty("id")
    private final int id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("description")
    private final String description;

    private String startWord = "";

    @Override
    public String toString() { return startWord + description; }
}
