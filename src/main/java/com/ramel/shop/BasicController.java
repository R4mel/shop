package com.ramel.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.LocalTime;


@Controller
public class BasicController {
    @GetMapping("/")
    @ResponseBody
    String home() {
        return "안녕하세요";
    }

    @GetMapping("/date")
    @ResponseBody
    String date() {
        return LocalDate.now() + " " + LocalTime.now();
    }
}
