package com.ramel.shop;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemRepository itemRepository;
    private final ItemService itemService;

    @GetMapping("/list")
    String list(Model model) {
        List<Item> result = itemService.findAll();
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
    String write(@ModelAttribute Item item) {
        itemService.saveItem(item);
        return "redirect:/list";
    }

    @GetMapping("/detail/{id}")
    String detail(@PathVariable Long id, Model model) {
        // throw new Exception();
        try {
            Optional<Item> result = itemService.findById(id);
            if (result.isPresent()) {
                model.addAttribute("item", result.get());
                return "detail.html";
            } else {
                return "redirect:/list";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/list";
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("에러에러");
        }
    }

//    @ExceptionHandler(Exception.class) // 모든 API의 에러 캐치
//    public void handler() {
//        return ResponseEntity.status().body();
//    }

    /*
    수정 기능?
    1. 수정 버튼 누르면 글 수정 페이지로
    2. 수정페이지엔 기존내용이 채워진 폼 있음
    3. 전송 누르면 그걸로 DB 수정
     */

    
}
