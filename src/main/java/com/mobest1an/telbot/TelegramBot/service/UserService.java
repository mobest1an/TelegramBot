package com.mobest1an.telbot.TelegramBot.service;

import com.mobest1an.telbot.TelegramBot.dto.User;
import com.mobest1an.telbot.TelegramBot.repository.Dao;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService extends BaseService {

    protected final Dao<User> repo;

    public List<User> getUserList() {
        log.trace("#### getUserList() - working");
        return wrapResults(repo.getAll());
    }


    public User getById(int id) {
        log.trace("#### getById() [id={}]", id);
        return wrapResult(repo.getById(id));
    }


    public void create(User entity) {
        log.trace("#### insert() [entity={}]", entity);
        repo.create(entity);
    }

    public void delete(User entity) {
        log.trace("#### delete() [entity={}]", entity);
        repo.delete(entity);
    }
}
