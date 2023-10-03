package com.example.servletexcercise.web.frontcontroller.v4.controller;

import com.example.servletexcercise.domain.member.Member;
import com.example.servletexcercise.domain.member.MemberRepository;
import com.example.servletexcercise.web.frontcontroller.v4.ControllerV4;

import java.util.List;
import java.util.Map;

public class MemberListControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        List<Member> memberList = memberRepository.findAll();

        model.put("members", memberList);

        return "members";
    }
}
