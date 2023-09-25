package com.example.servletexcercise.basic.response;

import com.example.servletexcercise.basic.Data.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        HelloData helloData = new HelloData();
        helloData.setUserName("kim");
        helloData.setAge(20);

        // {"username" : "kim" , "age" : 20}
        String object = objectMapper.writeValueAsString(helloData);

        //Writer 객체를 얻어
        resp.getWriter().write(object);
    }
}
