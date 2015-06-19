package com.learn.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gabbi on 19.06.15.
 */
@RestController
@RequestMapping("/test")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "Hello from boot";
    }
}
