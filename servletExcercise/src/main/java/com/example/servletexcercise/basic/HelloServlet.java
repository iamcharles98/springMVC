package com.example.servletexcercise.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// url 경로로 들어오는 요청에 해당 코드가 실행된다.
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // 브라우저에서 localhost:8080/hello 라는 경로로 HTTP Request를 생성해서 서버에 전달하면
        // req 매개변수에서 해당 Request를 전달 받을 수 있다. 
        System.out.println("req = " + req);
        System.out.println("res = " + res);
        System.out.println("HelloServlet.service");

        // getParameter -> 쿼리 파라미터를 받아 올 수 있는 메서드
        String username = req.getParameter("username");
        System.out.println("username = " + username);

        // 응답 헤더에 들어갈 내용을 넣어주는 메서드, 여기서는 Body에 담길 내용의 ContentType을 명시해주기 위해 사용했다.
        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");

        // 응답 Body에 내용을 넣어주는 메서드
        res.getWriter().write("hello" + username);
    }
}
