package com.amm.cloud.basic.cfg.interfaces;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ConfigController {

    @Value("${spring.application.name}")
    String name = "World";

    @GetMapping
    public String home() {
        return "Hello " + name;
    }
}
