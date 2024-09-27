package top.mqxu.cloud.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.mqxu.cloud.common.handler.FeignConfig;
import top.mqxu.cloud.common.mybatis.MyBatisConfig;
import top.mqxu.cloud.common.properties.SsyProperties;

/**
 * @author mqxu
 * @date 2024/9/11
 * @description ProductApplication
 **/
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({SsyProperties.class})
@Import({MyBatisConfig.class, FeignConfig.class})
@MapperScan(basePackages = {"top.mqxu.cloud.product.mapper"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}