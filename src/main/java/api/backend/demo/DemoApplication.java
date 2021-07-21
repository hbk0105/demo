package api.backend.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoApplication  extends SpringBootServletInitializer {

    @Autowired
    private StringRedisTemplate redisTemplate;

	@GetMapping("/")
	public String home() {

        System.out.println("###");

        try {

            ValueOperations<String, String> data = this.redisTemplate.opsForValue();
            data.set("001", "loveme");
            data.set("002", "1234");
            data.set("003", "aaa");

            System.out.println("### " + data.get("001"));



        }catch (Exception e){
            e.printStackTrace();
        }


	    return "Hello Docker World";
	}

	@GetMapping("/test")
	public String test() {
		return "Hello Docker TEST";
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}