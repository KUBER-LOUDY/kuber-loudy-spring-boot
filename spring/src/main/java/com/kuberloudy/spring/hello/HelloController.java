package com.kuberloudy.spring.hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("hello world, this is kuber-loudy spring server.",HttpStatus.OK);
    }
}
