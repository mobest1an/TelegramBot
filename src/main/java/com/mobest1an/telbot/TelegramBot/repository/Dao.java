package com.mobest1an.telbot.TelegramBot.repository;

import com.mobest1an.telbot.TelegramBot.dto.User;

import java.util.List;

public interface Dao<T> {

    T getById(int id);

    List<T> getAll();

    void create(T entity);

    void update(T entity);

    void delete(T entity);
}
