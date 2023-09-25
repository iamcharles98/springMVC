package com.example.servletexcercise.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //[status-line]
        resp.setStatus(HttpServletResponse.SC_OK);
        //resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);

        //[response-header]
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate" );
        resp.setHeader("Pragma","no-cahce");
        resp.setHeader("my-hedaer","hello");

        //[Header 편의 메서드]
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");

        // [Cookie 편의 메서드]
        // Key-Value 형식으로 넣어줄 수 있다.
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);

        //[redirect]
        resp.setStatus(HttpServletResponse.SC_FOUND);
        resp.setHeader("Location","/basic/hello-form.html");

        // [Redirect 편의 메서드]
        //resp.sendRedirect("/basic/hello-form.html");

        PrintWriter writer = resp.getWriter();
        writer.println("안녕하세요");
    }
}
