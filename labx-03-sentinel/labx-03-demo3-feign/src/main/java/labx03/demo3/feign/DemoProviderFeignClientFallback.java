package labx03.demo3.feign;

/**
 * @author zhaohu
 * @date 2020/6/24 3:54 下午
 * @description
 */
public class DemoProviderFeignClientFallback implements DemoProviderFeignClient {

    private Throwable throwable;

    public DemoProviderFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String flow(String arg) {
        return "DemoProviderFeignClientFallback flow :" + throwable.getClass().getSimpleName();
    }
}
