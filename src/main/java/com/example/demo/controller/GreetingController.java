package com.example.demo.controller;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Greeting;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private final Greeting greeting;

    public GreetingController(Greeting greeting){
        this.greeting = greeting;
    }

    //@Value("${greeting-name: Mirage}") //value 어노테이션은 괄호에 정의된 값을 사용하겠다는 표시임, EL로 프로퍼티값을 바로 꺼내쓸 수 있으며 : 을 이용해서 프로퍼티에 정의된 값이 없을 경우 초기값을 지정할 수 있음
    //private String name;

    //@Value("${greeting-coffee:${greeting-name} is drinking a cup of coffee}")
    //private String coffee;
    
    @GetMapping
    String getGreeting(){
        return this.greeting.getName();
    }

    @GetMapping("/coffee")
    String getNameAndCoffee(){
        return this.greeting.getCoffee();
    }

}
