package cn.stt.cloud.study.feign;

import cn.stt.cloud.study.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用@FeignClient("microservice-provider-user")注解绑定microservice-provider-user服务，
 * 还可以使用url参数指定一个URL
 *
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/5.
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);
}
