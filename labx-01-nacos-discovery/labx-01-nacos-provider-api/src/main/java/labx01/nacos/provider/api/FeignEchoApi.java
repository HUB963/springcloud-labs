package labx01.nacos.provider.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * FeignClient的name必须指定服务提供者
 *
 * @author zhaohu
 * @date 2020/6/18 3:22 下午
 * @description
 */
@FeignClient(name = "labx-01-nacos-provider")
public interface FeignEchoApi {

    @GetMapping("/feign/echo/{string}")
    String echo(@PathVariable("string") String string);
}
