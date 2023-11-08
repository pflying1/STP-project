package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.sentry.Sentry;
import io.sentry.protocol.Message;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        try {
            throw new Exception("테스트 예외");
        } catch (Exception e) {
            Message message = new Message();
            message.setMessage("예외 발생: " + e.getMessage());
            Sentry.captureException(e);
            return "예외가 발생하였습니다.";
        }
    }
}
