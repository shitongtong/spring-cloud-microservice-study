package cn.stt.cloud.study.service;

import cn.stt.cloud.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/5.
 */
@Service
public class RibbonService {
    @Autowired
    private RestTemplate restTemplate;

    public User findById(Long id) {
        // http://服务提供者的serviceId/url
        return restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
    }
}
