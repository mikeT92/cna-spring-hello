package edu.hm.cs.fwp.cloud.hello.adapter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hm.cs.fwp.cloud.hello.core.boundary.HelloWorld;

@RestController
@RequestMapping("hello")
@CrossOrigin
public class HelloController {

	@Autowired
	HelloWorld boundary;
	
	@GetMapping
	public String getWelcomeMessage() {
		return boundary.getHelloMessage().getText();
	}
}
