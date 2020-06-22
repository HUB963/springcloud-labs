package labx02.nacos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhaohu
 * @date 2020/6/19 6:51 下午
 * @description
 */
@Configuration
@ConfigurationProperties(prefix = "ext0.user")
public class ExtConfigPOJO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
