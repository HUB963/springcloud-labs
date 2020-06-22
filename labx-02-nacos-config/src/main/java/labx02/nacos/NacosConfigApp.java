package labx02.nacos;

import labx02.nacos.config.ConfigPOJO;
import labx02.nacos.config.ExtConfigPOJO;
import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohu
 * @date 2020/6/19 2:15 下午
 * @description
 */
@SpringBootApplication
public class NacosConfigApp {
    static ConfigurableApplicationContext applicationContext = null;

    public static void main(String[] args) {
        applicationContext = SpringApplication.run(NacosConfigApp.class, args);
    }

    @RefreshScope
    @RestController
    public class ConfigController {

        @Autowired
        ConfigPOJO configPOJO;

        @Autowired
        ExtConfigPOJO extConfigPOJO;

        @GetMapping("/nacos/config/get/{key}")
        public String getConfig(@PathVariable("key") String key) {
            String value = applicationContext.getEnvironment().getProperty(key);
            if (StringUtils.isBlank(value)) {
                return "property " + key + " is not exist.";
            } else {
                return "property " + key + " value is " + value;
            }
        }

        @GetMapping("/nacos/config/test/username")
        public String getConfig() {
            return configPOJO.getUserName();
        }

        @GetMapping("/nacos/config/ext0/username")
        public String getExtConfig() {
            return extConfigPOJO.getName();
        }

        @Autowired
        StringEncryptor stringEncryptor;

        @GetMapping("/nacos/config/jasypt/encode")
        public void encode() {
            String password = "woshimima";
            System.out.println(stringEncryptor.encrypt(password));

            password = "bushimima";
            System.out.println(stringEncryptor.encrypt(password));
        }

        @Value("${xxx.password:}")
        private String xxxPassword;

        @GetMapping("/nacos/config/jasypt/get")
        public String getPassword() {
            return xxxPassword;
        }

    }

}
