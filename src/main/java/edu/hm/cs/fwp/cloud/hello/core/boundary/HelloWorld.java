package edu.hm.cs.fwp.cloud.hello.core.boundary;

import java.util.Locale;
import java.util.UUID;

import org.springframework.stereotype.Service;

import edu.hm.cs.fwp.cloud.hello.core.entity.Message;

@Service
public class HelloWorld {

	public Message getHelloMessage() {
		Message result = new Message(UUID.randomUUID());
		result.setCode("hello");
		result.setText("Herzlich Willkommen bei Spring Boot!");
		result.setLocale(Locale.GERMAN);
		return result;
	}
}
