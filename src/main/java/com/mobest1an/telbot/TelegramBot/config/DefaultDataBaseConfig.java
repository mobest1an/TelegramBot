package com.mobest1an.telbot.TelegramBot.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;

@Slf4j
public class DefaultDataBaseConfig {

    protected DataSource hikariDataSource(String tag, DataBaseConfig.SpringDataJdbcProperties properties) {
        log.info("[{}] настройки БД: [{}]", tag, properties.toString());

        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(properties.getUrl());
        ds.setDriverClassName(properties.getDriver());
        ds.setUsername(properties.getUser());
        ds.setPassword(properties.getPassword());
        ds.setMaximumPoolSize(Integer.parseInt(properties.getPoolSize()));
        return ds;
    }
}
