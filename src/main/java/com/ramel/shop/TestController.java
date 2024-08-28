package com.ramel.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    @GetMapping("/test")
    String test(Model model) {
        List<Test> items = testRepository.findAll();
        model.addAttribute("items", items);
        return "test.html";
    }
}
