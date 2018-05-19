package com.piyush.projects.sleuthdemo.sleuth;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SleuthApplication {

	private static final Logger _LOG=Logger.getLogger(SleuthApplication.class.getName());
	
	@Autowired
	RestTemplate restTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
	@RequestMapping(value="/")
	public String indexPage() {
		_LOG.log(Level.INFO,"");		
		return "pagal";
	}
	
	@RequestMapping(value="/home")
	public String home() {
		_LOG.log(Level.INFO,"");		
		return "pagal home";
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
	
}
