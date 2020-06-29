package labx03.demo3.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author zhaohu
 * @date 2020/6/24 4:09 下午
 * @description
 */
@Component
public class DemoProviderFeignClientFallbackFactory implements FallbackFactory<DemoProviderFeignClientFallback> {
    @Override
    public DemoProviderFeignClientFallback create(Throwable throwable) {
        return new DemoProviderFeignClientFallback(throwable);
    }
}
