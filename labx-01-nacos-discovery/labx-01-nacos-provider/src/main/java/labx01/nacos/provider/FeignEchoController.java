package labx01.nacos.provider;

import labx01.nacos.provider.api.FeignEchoApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohu
 * @date 2020/6/18 5:38 下午
 * @description
 */
@RestController
public class FeignEchoController implements FeignEchoApi {

    public String echo(String string) {
        return "Hello Nacos Discovery " + string;
    }
}
