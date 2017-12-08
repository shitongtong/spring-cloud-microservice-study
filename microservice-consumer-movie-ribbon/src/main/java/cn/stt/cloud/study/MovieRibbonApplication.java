package cn.stt.cloud.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/5.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MovieRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(MovieRibbonApplication.class, args);
    }

    /**
     * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载能力.
     *
     * @return RestTemplate
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
