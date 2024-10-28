package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dao.CoffeeRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {
    private final CoffeeRepository coffeeRepository;

    public DataLoader(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository;
    }
    
    @PostConstruct //어플리케이션이 was에서 기동될때 bean이 생성되고나서 딱 한번만 호출되도록 설정하는 어노테이션
    private void loadData(){
        coffeeRepository.saveAll(List.of(
            new Coffee("Cafe Cerenza"),
            new Coffee("Cafe Ganador"),
            new Coffee("Cafe Lareno"),
            new Coffee("Cafe Tres Pontas"),
            new Coffee("Arfegio")
        ));
    }
}
