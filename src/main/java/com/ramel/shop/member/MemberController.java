package com.ramel.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/joinMember")
    String joinMember(@RequestParam String username, @RequestParam String displayName, @RequestParam String password) {
        Member member = new Member();
        member.setUsername(username);
        BCryptPasswordEncoder passwordEncoder
        member.setPassword(password);
        member.setDisplayName(displayName);
        memberRepository.save(member);
        return "redirect:/list";
    }
}
