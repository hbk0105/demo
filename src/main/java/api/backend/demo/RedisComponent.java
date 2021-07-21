package api.backend.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisComponent implements ApplicationRunner {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        System.out.println("###");
        ValueOperations<String, String> data = this.redisTemplate.opsForValue();
        data.set("001", "loveme");
        data.set("002", "1234");
        data.set("003", "aaa");

        System.out.println("### " + data.get("001"));
    }
}
