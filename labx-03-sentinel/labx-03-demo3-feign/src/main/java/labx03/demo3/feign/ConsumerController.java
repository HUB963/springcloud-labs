package labx03.demo3.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohu
 * @date 2020/6/24 3:15 下午
 * @description
 */
@RestController
@RequestMapping("/demo3")
public class ConsumerController {

    @Autowired
    DemoProviderFeignClient client;

    @GetMapping("/consumer/feign/flow")
    public String consumerFeignFlow(@RequestParam(name = "arg", required = false) String arg) {
        return client.flow(arg);
    }
}
