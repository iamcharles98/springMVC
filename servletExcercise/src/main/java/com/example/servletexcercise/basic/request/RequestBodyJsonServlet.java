package com.example.servletexcercise.basic.request;

import com.example.servletexcercise.basic.Data.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream inputStream = req.getInputStream();
        // Json도 결국엔 문자열 형태로 들어온다. 다만 Content-type에 json 이라고 명시되어 있기 떄문에,
        // 따로 파싱할 수 있는 라이브러리를 활용하여 객체 형태로 변환이 가능하다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);

        // Json to Object 파싱
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);

        System.out.println("userName = " + helloData.getUserName());
        System.out.println("age = " + helloData.getAge());

        resp.getWriter().write("ok");

    }
}
