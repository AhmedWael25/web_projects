package com.playground;

import com.playground.models.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class ConsumerdemoApplication {
	private static final Logger log = LoggerFactory.getLogger(ConsumerdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumerdemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTempalte(RestTemplateBuilder restTemplateBuilder){
		return restTemplateBuilder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
//		For Testing
		return  args -> {

			String uri = "http://localhost:9800/api/";
			Customer customer = restTemplate.getForObject(uri+"customers/1", Customer.class);
			System.out.println(customer);

			HttpEntity<Customer> httpEntity = new HttpEntity<>(new Customer("from","template", 9769));
			Customer customer1 = restTemplate.postForObject(uri+"/customers",httpEntity, Customer.class);
			System.out.println(customer1);
		};
	}

}
