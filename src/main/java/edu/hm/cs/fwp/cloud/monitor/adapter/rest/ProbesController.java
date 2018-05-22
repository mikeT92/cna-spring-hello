/*
 * cna-spring-persistence:ProbesController.java
 * Copyright (c) Michael Theis 2017
 */
package edu.hm.cs.fwp.cloud.monitor.adapter.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO: add documentation!
 * 
 * @author mikeT92
 * @version 1.0
 * @since 22.05.2018
 */
@RestController
@RequestMapping("probes")
public class ProbesController {

	@GetMapping("readiness")
	public ResponseEntity<?> checkReadiness() {
		return ResponseEntity.ok().build();
	}

	@GetMapping("liveness")
	public ResponseEntity<?> checkLiveness() {
		return ResponseEntity.ok().build();
	}
}
