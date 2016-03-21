package io.ctl.pcf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@RestController
@EnableFeignClients
public class DemoLoadGeneratorApplication {

	@Autowired
	private PiService piService;

	public static void main(String[] args) {
		SpringApplication.run(DemoLoadGeneratorApplication.class, args);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/load/{digits}/requestCount/{requestCount}/delayMS/{delay}")
	public void startLoad(@PathVariable("digits") int piDigits, @PathVariable("requestCount") int requestCount, @PathVariable long delay) throws InterruptedException {
		for (int count = 0; count < requestCount; count++) {
			piService.calculatePi(piDigits);
			Thread.sleep(delay);
		}
	}
}
