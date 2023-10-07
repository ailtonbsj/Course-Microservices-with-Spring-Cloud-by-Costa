package br.ailtonbsj.greeting.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ailtonbsj.greeting.configurations.GreetingConfiguration;
import br.ailtonbsj.greeting.models.Greeting;

@RestController
public class GreetingController {
	
	private static final String template = "%s, %s!";
	
	@Autowired
	private GreetingConfiguration conf;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		if(name.isEmpty()) name = conf.getDefaultValue();
		return new Greeting(1, String.format(template, conf.getGreeting(), name));
	}
	
}
