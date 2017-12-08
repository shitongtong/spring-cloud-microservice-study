package cn.stt.cloud.study.controller;

import cn.stt.cloud.study.entity.User;
import cn.stt.cloud.study.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/8.
 */
@RestController
public class FeignController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("feign/{id}")
    public User findByIdFeign(@PathVariable Long id){

        return userFeignClient.findByIdFeign(id);
    }
}
