package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableAsync
public class BobDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BobDemoApplication.class, args);
	}

	@Value("#{environment.CF_INSTANCE_INDEX ?: 'NO_INDEX'}")
	private String cfInstanceIndex;

	@Value("#{environment.CF_INSTANCE_ADDR ?: 'NO_ADDRESS'}")
	private String cfInstanceAddress;

	@RequestMapping(value = "/pi/{digits}", method = RequestMethod.GET)
	public Map<String, String> calculatePi(@PathVariable int digits) {
		Map<String, String> result = new HashMap<>();
		result.put("greeting", "The ABCs of 1-2-3s baby!");
		result.put("pi", PiDigits.pi_digits(digits > 0 ? digits : 100));
		return result;
	}

	@RequestMapping(value = "/piAsync/{digits}", method = RequestMethod.GET)
	@Async
	public Map<String, String> calculatePiAsync(@PathVariable int digits) {
		return this.calculatePi(digits);
	}

	@RequestMapping(value = "/cfData", method = RequestMethod.GET)
	public Map<String, String> getCFData() {
		Map<String, String> result = new HashMap<>();
		result.put("cfInstanceIndex", cfInstanceIndex);
		result.put("cfInstanceAddress", cfInstanceAddress);
		return result;
	}
}
