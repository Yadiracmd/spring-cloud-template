package top.mqxu.cloud.order;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import top.mqxu.cloud.common.handler.FeignConfig;
import top.mqxu.cloud.common.mybatis.MyBatisConfig;
import top.mqxu.cloud.common.properties.SsyProperties;

/**
 * @author mqxu
 * @date 2024/9/11
 * @description OrderApplication
 **/
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy(exposeProxy = true)
@EnableConfigurationProperties({SsyProperties.class})
@Import({MyBatisConfig.class, FeignConfig.class})
@MapperScan(basePackages = {"top.mqxu.cloud.order.mapper"})
@Slf4j
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}