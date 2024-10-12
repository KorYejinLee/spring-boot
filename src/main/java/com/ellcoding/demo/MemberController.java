package com.ellcoding.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("member", new Member());
        return "home";
    }

    @PostMapping("/")
    public String addMember(@ModelAttribute RequestMember request) {
        Member member = new Member(request.name(), request.age());
        memberRepository.save(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "membersForm";
    }
}