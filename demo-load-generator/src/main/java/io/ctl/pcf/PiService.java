package io.ctl.pcf;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Service
@FeignClient(url = "http://se-demo.10.141.158.128.xip.io")
//@FeignClient(url = "http://localhost:8080")
public interface PiService {

	@RequestMapping(method = RequestMethod.GET, value = "/piAsync/{digits}", consumes = "application/json")
	Map<String, String> calculatePi(@PathVariable("digits") int digits);
}
