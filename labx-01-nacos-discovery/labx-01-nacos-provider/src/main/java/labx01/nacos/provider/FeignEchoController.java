package labx01.nacos.provider;

import labx01.nacos.provider.api.FeignEchoApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

/**
 * @author zhaohu
 * @date 2020/6/18 5:38 下午
 * @description
 */
@RestController
public class FeignEchoController implements FeignEchoApi {

    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private int port;
    @Autowired
    Environment environment;

    public String echo(String string) {
        String host = "";
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
        }
        return "Hello Nacos Discovery " + string + ", I'm " + appName + "@" + host + ":" + port;

    }
}
