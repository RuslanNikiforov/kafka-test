package koda.kafkaTest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {

    @GetMapping("/root")
    public String getRoot() {
        return "Hello World!";
    }
}
