package com.ramel.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
