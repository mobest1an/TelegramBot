package com.mobest1an.telbot.TelegramBot.service;

import com.mobest1an.telbot.TelegramBot.dto.User;
import com.mobest1an.telbot.TelegramBot.repository.Dao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    private static final String TOPIC = "users";
    protected final Dao<User> repo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public Producer(Dao<User> repo) {
        this.repo = repo;
    }

    public void sendMessage(User user) {
        if (user.getName() == null || user.getDescription().isEmpty()) log.info("#### Empty name/description message");
        log.info("#### Producing message [user={}]", user);
        kafkaTemplate.send(TOPIC, "Writing in log -> " + user);
    }
}
