package com.ramel.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // 모든 Controller 파일의 에러 캐치
public class MyExceptionHandler { // 컨트롤러마다 Exception 코드를 넣는게 귀찮을 때 사용
    @ExceptionHandler(Exception.class) // 모든 API의 에러 캐치
    public ResponseEntity<String> handler() {
        return ResponseEntity.status(400).body("에러에러");
    }
}
