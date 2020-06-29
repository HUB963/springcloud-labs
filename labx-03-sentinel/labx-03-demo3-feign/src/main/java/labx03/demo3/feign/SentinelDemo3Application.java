package labx03.demo3.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhaohu
 * @date 2020/6/23 10:32 上午
 * @description
 */
@SpringBootApplication
@EnableFeignClients
public class SentinelDemo3Application {
    public static void main(String[] args) {
        SpringApplication.run(SentinelDemo3Application.class, args);
    }
}
