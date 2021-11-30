package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hf
 * date   2021/11/25 15:55
 * description
 */
@RestController
public class HelloController {

    @GetMapping("/baby")
    public String hello() {
        return "baby";
    }


    @GetMapping("/biz")
    public String biz() {
        return "biz";
    }

}