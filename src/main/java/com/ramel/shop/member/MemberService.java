package com.ramel.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void joinMember(@ModelAttribute Member member) {
        memberRepository.save(member);
    }
}
