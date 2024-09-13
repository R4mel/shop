package com.ramel.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    String register(Authentication authentication) {
        if (authentication.isAuthenticated()) {
            return "redirect:/list";
        }
        return "register.html";
    }

    @PostMapping("/joinMember")
    String joinMember(@RequestParam String username, @RequestParam String displayName, @RequestParam String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setDisplayName(displayName);
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/my-page")
    public String myPage(Authentication authentication) {
        System.out.println(authentication);
        System.out.println(authentication.getName());
        return "mypage.html";
    }

    /*
    1. Map 자료에 필요한 것만 넣어서 보내기
    2.
     */
    @GetMapping("/user/1")
    @ResponseBody
    public MemberDto getUser() {
        var a = memberRepository.findById(1L);
        return new MemberDto(a.get().getUsername(), a.get().getDisplayName());
    }
}

class MemberDto { // Data Transfer Object: 데이터 변환용 클래스
    public String username;
    public String displayName;

    MemberDto(String a, String b) {
        this.username = a;
        this.displayName = b;
    }
}

/*
    DTO의 장점?
    1. 보내는 데이터의 타입체크가 쉬움
    2. 재사용이 쉬움
 */