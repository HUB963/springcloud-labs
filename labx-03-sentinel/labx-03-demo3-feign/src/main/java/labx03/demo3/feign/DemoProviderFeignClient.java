package labx03.demo3.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 自定义一个feign client，实现对demo1-provider的声明式调用
 *
 * @author zhaohu
 * @date 2020/6/24 3:00 下午
 * @description
 */
@FeignClient(name = "labx-03-demo1", url = "http://127.0.0.1:8080", fallbackFactory = DemoProviderFeignClientFallbackFactory.class)
public interface DemoProviderFeignClient {

    @GetMapping("/demo1/flow")
    String flow(@RequestParam(name = "arg", required = false) String arg);
}
