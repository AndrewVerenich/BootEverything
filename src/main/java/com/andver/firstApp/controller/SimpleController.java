package com.andver.firstApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final String SELECT = "SELECT current_count FROM count WHERE id=1";
    private final String UPDATE = "UPDATE count SET current_count = current_count + 1 WHERE id = 1";

    private final JdbcTemplate template;

    @Autowired
    public SimpleController(JdbcTemplate template) {
        this.template = template;
    }

    @GetMapping("/")
    String home() {
        String string = "Hello World!" + template.queryForObject(SELECT, String.class);
        template.update(UPDATE);
        return string;
    }
}
