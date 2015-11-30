package basic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsRestController {

	@RequestMapping("/hi")
	public Map<String, Object> hi() {
		Map<String, Object> result = new HashMap<>();
		result.put("id", UUID.randomUUID().toString());
		result.put("content", "Hello, world!");
		return result;
	}

}
