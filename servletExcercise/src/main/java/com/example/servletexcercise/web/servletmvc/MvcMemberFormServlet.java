package com.example.servletexcercise.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //WEB-INF 안에 JSP가 있으면 외부에서 직접 JSP로 접근할 수 없다.
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // 서버 내부에서 호출한다.
        // 즉, 브라우저 -> 서버 -> 서버 -> 브라우저이다.
        // redirect 와 forward 가 차이가 있다.
        dispatcher.forward(request,response);
    }
}
