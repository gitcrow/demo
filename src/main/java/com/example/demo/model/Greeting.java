package com.example.demo.model;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    private String name;
    private String coffee;

    public String getCoffee() {
        return this.coffee;
    }

    public void setCoffee(String coffee) {
        this.coffee = coffee;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

}
