package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.print("Welcon U to there.");

		if (name.equals("dreamer"))
		{
			return new Greeting(counter.incrementAndGet(), String.format(template, "you're dreamer"));
		}
		else{
			System.out.print("You input name is:");
			System.out.print(name);
		}
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
