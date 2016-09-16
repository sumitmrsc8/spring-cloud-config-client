package com.example.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@Component
@RestController
public class Greeter {
	// These values are pulled from GIT config 
	@Value("${message.greeting}")
	String greeting;
	@Value("${server.port}")
	int port;
	@Value("${configuration.projectName}")
	String projectName;
	
	@RequestMapping(value="/",produces="application/json")
	public List<String> index(){
		List<String> env=Arrays.asList("message.greeting is "+greeting+" server.port is "+port+" configuration.projectName is "+projectName );
		return env;
	}
}
