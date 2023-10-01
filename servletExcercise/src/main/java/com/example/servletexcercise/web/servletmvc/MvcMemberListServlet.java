package com.example.servletexcercise.web.servletmvc;

import com.example.servletexcercise.domain.member.Member;
import com.example.servletexcercise.domain.member.MemberRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> memberList = memberRepository.findAll();

        req.setAttribute("members", memberList);

        String viewPath = "/WEB-INF/views/members.jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(viewPath);
        requestDispatcher.forward(req, resp);

    }
}
