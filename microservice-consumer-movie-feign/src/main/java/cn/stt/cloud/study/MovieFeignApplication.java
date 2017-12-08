package cn.stt.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 使用@EnableFeignClients开启Feign
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/5.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MovieFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieFeignApplication.class, args);
    }
}
