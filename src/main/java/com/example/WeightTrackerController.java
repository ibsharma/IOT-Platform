package com.example;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ishaan
 */
@RestController
@EnableAutoConfiguration
public class WeightTrackerController {
    @RequestMapping("/")
    public String index() {
        return "Hey there";
    }
}
