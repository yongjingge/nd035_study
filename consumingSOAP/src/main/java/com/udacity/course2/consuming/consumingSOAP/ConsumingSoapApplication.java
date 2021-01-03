package com.udacity.course2.consuming.consumingSOAP;

import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@SpringBootApplication
public class ConsumingSoapApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingSoapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		NumberClient numberClient = new NumberClient();

		// create and setup marshaller
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

		// provide location to the ObjectFactory
		marshaller.setContextPath("com.dataaccess.webservicesserver");

		// add marshaller to the numberClient
		numberClient.setMarshaller(marshaller);
		numberClient.setUnmarshaller(marshaller);

		// retrieve the word format (response) of the number
		String target = "1319";
		NumberToWordsResponse res = numberClient.getWords(target);

		// print result to screen
		System.out.println("Response is: " + res.getNumberToWordsResult());

	}
}
