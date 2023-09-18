package com.example.servletexcercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan // 하위 패키지의 서블릿을 찾아서 등록해준다 //
public class ServletExcerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletExcerciseApplication.class, args);
    }

}
