package top.mqxu.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.mqxu.cloud.common.handler.FeignConfig;
import top.mqxu.cloud.common.handler.SentinelConfig;
import top.mqxu.cloud.common.mybatis.MyBatisConfig;
import top.mqxu.cloud.common.properties.JwtProperties;
import top.mqxu.cloud.common.properties.SsyProperties;

/**
 * @author mqxu
 * @date 2024/9/11
 * @description UserApplication
 **/
@SpringBootApplication
@EnableFeignClients
@Import({MyBatisConfig.class, FeignConfig.class, SentinelConfig.class })
@EnableConfigurationProperties({SsyProperties.class, JwtProperties.class})

public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
