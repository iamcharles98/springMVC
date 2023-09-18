package com.example.servletexcercise.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);

    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("--- Header 편의 조회 start ------------");
        System.out.println("[ HOST 편의 조회 ]");

        System.out.println("request.getServerName() = " + req.getServerName());
        System.out.println("request.getServerPort() = " + req.getServerPort());
        System.out.println();

        System.out.println("[ Accept-Language 편의 조회 ]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- HEADER - start ---------");
//        예전에 자주 사용하던 방식
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName : " + headerName);
//        }
        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println("headerName : " + headerName));

        System.out.println("--- HEADER - end -------------");
        System.out.println();
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("--- REQUEST - LINE - start -------");

        // HttpRequest의 START LINE에 대한 정보들을 조회할 수 있도록 지원하는 메서드들이 다양히 존재한다. //
        System.out.println("request.getMethod() = " + req.getMethod());
        System.out.println("request.getProtocol() = " + req.getProtocol());
        System.out.println("request.getScheme() = " + req.getScheme());

        System.out.println("--- REQUEST - LINE - end ---------");
    }
}
