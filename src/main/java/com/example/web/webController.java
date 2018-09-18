package com.example.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by XiuYin.Cui on 2018/9/15.
 */
@RestController
public class webController {

    @RequestMapping("/")
    String home() {
        return "Hello Boot";
    }
}
