package com.example.servletexcercise.web.springmvc.v1;

import com.example.servletexcercise.domain.member.Member;
import com.example.servletexcercise.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class SpringMemberSaveControllerV1 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) {
        String userName = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(userName,age);

        memberRepository.save(member);

        ModelAndView modelAndView = new ModelAndView("save-result");
        modelAndView.addObject("member",member);
        return modelAndView;
    }
}
