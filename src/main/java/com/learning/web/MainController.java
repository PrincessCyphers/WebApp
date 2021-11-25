package com.learning.web;

import com.learning.user.User;
import com.learning.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class MainController {

    private final UserRepository repository;

    public MainController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping(" ")
    public String showHomePage() {
        return "index";
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value="/users", produces = APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        final Iterable<User> all = repository.findAll();
        final List<User> users = new ArrayList<>();
        all.forEach(users::add);
        return users;
    }
}
