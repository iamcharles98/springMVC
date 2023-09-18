package com.example.servletexcercise.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
    1. 파라미터 전송 기능
    http://localhost:8080/request-param?username=hello&age=20
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printAllParams(req);

        printParamsWithDupName(req);

    }

    private static void printParamsWithDupName(HttpServletRequest req) {
        /*
        파라미터 이름은 하나인데 값이 여러개이면
        getParameterValues() 함수로 해당하는 이름의 모든 Param을 받아올 수 있다.
        대부분의 경우 단일 파라미터를 사용해서 요청을 보낸다.
         */
        System.out.println("[ 이름이 같은 복수 파라미터 조회]");
        String[] usernames = req.getParameterValues("username");
        for (String username : usernames) {
            System.out.println("username = " + username);
        }
    }

    private static void printAllParams(HttpServletRequest req) {
        System.out.println("[전체 파라미터 조회] --- start");

        req.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] --- end");
    }
}
