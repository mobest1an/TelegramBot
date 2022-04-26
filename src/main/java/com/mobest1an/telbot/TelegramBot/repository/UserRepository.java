package com.mobest1an.telbot.TelegramBot.repository;

import com.mobest1an.telbot.TelegramBot.dto.User;
import com.mobest1an.telbot.TelegramBot.dto.UserMapper;
import com.mobest1an.telbot.TelegramBot.exceptions.DbException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class UserRepository implements Dao<User> {

    private static final String SQL_SELECT_BY_NAME = "" +
            "SELECT id, user_name, description FROM user_table WHERE id=?";
    private static final String SQL_SELECT_LIST = "" +
            "SELECT id, user_name, description FROM user_table";
    private static final String SQL_INSERT = "" +
            "INSERT INTO user_table (user_name, description) VALUES (?, ?)";
    private static final String SQL_DELETE = "" +
            "DELETE FROM user_table WHERE id = ?";

    protected final static UserMapper USER_MAPPER = new UserMapper();

    protected final JdbcTemplate template;

    public UserRepository(@Qualifier("bot-db") JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public User getById(int id) throws DbException {
        try {
            return DataAccessUtils.singleResult(template.query(SQL_SELECT_BY_NAME, USER_MAPPER, id));
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return template.query(SQL_SELECT_LIST, USER_MAPPER);
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }

    }

    @Override
    public void create(User entity) throws DbException {
        try {
            var result = template.update(SQL_INSERT, entity.getName(), entity.getDescription());
            if (result != 1) log.trace("UserRepository.update() with {} rows inserted", entity);
            log.info("insert({}) result={}", entity, result);
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) throws DbException {
        try {
            var result = template.update(SQL_DELETE, entity.getId());
            if (result != 1) log.trace("UserRepository.delete() with {} rows inserted", entity);
            log.info("delete({}) result={}", entity, result);
        } catch (DataAccessException exception) {
            throw new DbException(exception);
        }
    }
}
