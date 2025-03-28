package com.example.ribbonserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@Autowired
	Environment environment;

	@GetMapping("/")
	public String health() {
		return "Ok";
	}

	@GetMapping("/backend")
	public String backend() {
		System.out.println("MyRestController::backend...");

		String serverPort = environment.getProperty("local.server.port");

		System.out.println("Port : " + serverPort);
		
		return "Hello!!! " + " Host : localhost " + " :: Port : " + serverPort;
	}
}
