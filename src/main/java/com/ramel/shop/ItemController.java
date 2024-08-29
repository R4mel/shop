package com.ramel.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemRepository.findAll();
//        model.addAttribute("전달할데이터이름", "데이터");
        model.addAttribute("items", result);
        return "list.html";
    }
    
    /*
    상품추가 기능?
    1. 상품 이름, 가격 작성할 수 있는 페이지와 폼
    2. 전송버튼 누르면 서버로 보냄
    3. 서버는 검사 후 이상없으면 DB 저장
     */

    @GetMapping("/write")
    String write() {
        return "write.html";
    }

    @PostMapping("/add")
    String write(String title, String price) {
        return "redirect:/list";
    }
}
