package com.mobest1an.telbot.TelegramBot.controller;

import com.mobest1an.telbot.TelegramBot.dto.User;
import com.mobest1an.telbot.TelegramBot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("${app.http.bot")
@RequiredArgsConstructor
public class UsersPlansController {

    private final UserService userService;

    @GetMapping(path = "/users_idea")
    public List<User> getIdeaList() {
        log.debug("Method - getIdeaList was called");
        return userService.getUserList();
    }
}
