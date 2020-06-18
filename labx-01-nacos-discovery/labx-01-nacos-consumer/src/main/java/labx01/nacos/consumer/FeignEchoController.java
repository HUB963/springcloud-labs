package labx01.nacos.consumer;

import labx01.nacos.provider.api.FeignEchoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohu
 * @date 2020/6/18 6:17 下午
 * @description
 */
@RestController
public class FeignEchoController {
    @Autowired
    private FeignEchoApi feignEchoApi;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/feign/echo/app-name")
    public String echo() {
        return feignEchoApi.echo(appName);
    }
}
