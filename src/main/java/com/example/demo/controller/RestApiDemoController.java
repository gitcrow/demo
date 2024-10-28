package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CoffeeRepository;
import com.example.demo.model.Coffee;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@RestController
@RequestMapping("/coffees")
public class RestApiDemoController{
    private final CoffeeRepository coffeeRepository;
//	private List<Coffee> coffees = new ArrayList<>();

	public RestApiDemoController(CoffeeRepository coffeeRepository){
		this.coffeeRepository = coffeeRepository;
        // this.coffeeRepository.saveAll(List.of(
        //     new Coffee("Cafe Cerenza"),
        //     new Coffee("Cafe Ganador"),
        //     new Coffee("Cafe Lareno"),
        //     new Coffee("Cafe Tres Pontas")
        // ));
        // coffees.addAll(List.of(
		// 					new Coffee("Cafe Cerenza"),
		// 					new Coffee("Cafe Ganador"),
		// 					new Coffee("Cafe Lareno"),
		// 					new Coffee("Cafe Tres Pontas")
		// ));
	}

	@GetMapping
	Iterable<Coffee> getCoffees(){
		return coffeeRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<Coffee> getCoffeeById(@PathVariable String id){
		// for(Coffee c: coffees){
		// 	if(c.getId().equals(id)){
		// 		return Optional.of(c);
		// 	}
		// }
		return coffeeRepository.findById(id); //findById가 optional 타입을 반환함
	}

	@PostMapping
	Coffee postCoffee(@RequestBody Coffee coffee){//추가    
		//coffees.add(coffee);
		
		return coffeeRepository.save(coffee);
	}

	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee){//업데이트, @RequestBody는 요청들어온 json을 자바 객체로 변환해줌
		//int coffeeIndex = -1;

		// for(Coffee c : coffees){
		// 	if(c.getId().equals(id)){
		// 		coffeeIndex = coffees.indexOf(c);
		// 		coffees.set(coffeeIndex, coffee);
		// 	}
		// }
		//return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) : new ResponseEntity<>(coffee, HttpStatus.OK);

        return (coffeeRepository.existsById(id)) 
            ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK)
            : new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id){
        coffeeRepository.deleteById(id);
		//coffees.removeIf(c -> c.getId().equals(id));
	}

}
