package com.example.demo.controller.api.hello;

import com.example.demo.controller.api.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Api.API_V1_URI)
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
