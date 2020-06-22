package labx02.nacos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author zhaohu
 * @date 2020/6/19 6:51 下午
 * @description
 */
@Component
@RefreshScope
public class ConfigPOJO implements Serializable {

    @Value("${test.user.name:}")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
