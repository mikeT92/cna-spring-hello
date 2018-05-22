package edu.hm.cs.fwp.cloud.hello.core.boundary;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hm.cs.fwp.cloud.hello.adapter.persistence.MessageRepository;
import edu.hm.cs.fwp.cloud.hello.core.entity.Message;

@Service
public class HelloWorld {

	private static final String HELLO_MESSAGE_ID = "c2745643-54e9-489e-8e76-e32f80ec50df";

	@Autowired
	MessageRepository repository;

	public Message getHelloMessage() {
		return this.repository.findById(UUID.fromString(HELLO_MESSAGE_ID)).get();
	}
}
