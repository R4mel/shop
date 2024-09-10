package com.ramel.shop.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/modify/{id}")
    public String modify(@PathVariable Long id, Model model) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            itemRepository.save(item.get());
            model.addAttribute("item", item.get());
            return "modify.html";
        } else {
            return "redirect:/list";
        }
    }

    @PostMapping("/modify")
    String modifyItem(@RequestParam String title, @RequestParam Integer price, @RequestParam Long id) throws Exception {
        itemService.modifyItem(id, title, price);
        return "redirect:/list";
    }

    /*
    삭제 기능?
    1. 상품마다 삭제버튼 만들기
    2. 누르면 서버에 요청하고 서버는 DB에 있던 행 삭제
     */
    @DeleteMapping("/delete")
    public String deleteItem(@RequestParam Long id) {
        Optional<Item> Item = itemService.findById(id);
        if (Item.isPresent()) {
            itemRepository.deleteById(id);
        }
        return "redirect:/list";
    }

    /*
    1. 새로고침없이 요청날리고 데이터 받아올려면 AJAX
    2. query string, URL parameter 써도 서버로 데이터 전송가능
    3. 자바스크립트 안에 Thymeleaf 변수 넣기 가능
     */

    /*
    회원가입 기능?
    1. 회원가입페이지 필요
    2. username/password/displayName 입력하면 DB 저장(비번은 hashing해서 저장)
    4. 테이블 이름은 Member
     */

}

