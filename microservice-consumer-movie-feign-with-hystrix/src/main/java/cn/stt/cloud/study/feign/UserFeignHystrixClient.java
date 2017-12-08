package cn.stt.cloud.study.feign;

import cn.stt.cloud.study.entity.User;
import cn.stt.cloud.study.feign.UserFeignHystrixClient.HystrixClientFallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/8.
 */
@FeignClient(name = "microservice-provider-user", fallback = HystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @RequestMapping("/{id}")
    public User findByIdFeign(@RequestParam("id") Long id);

    /**
     * 这边采取了和Spring Cloud官方文档相同的做法，将fallback类作为内部类放入Feign的接口中，当然也可以单独写一个fallback类。
     */
    @Component
    static class HystrixClientFallback implements UserFeignHystrixClient {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallback.class);


        /**
         * hystrix fallback方法
         *
         * @param id
         * @return 默认的用户
         */
        @Override
        public User findByIdFeign(Long id) {
            LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
            User user = new User();
            user.setId(-1L);
            user.setUsername("default username");
            user.setAge(0);
            return user;
        }
    }


    /*@Component
    static class HystrixClientFallbackFactory implements FallbackFactory<UserFeignHystrixClient> {
        private static final Logger LOGGER = LoggerFactory.getLogger(HystrixClientFallbackFactory.class);

        @Override
        public UserFeignHystrixClient create(Throwable throwable) {
            return new UserFeignHystrixClient() {
                @Override
                public User findByIdFeign(@RequestParam("id") Long id) {
                    LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
                    User user = new User();
                    user.setId(-1L);
                    user.setUsername("default username");
                    user.setAge(0);
                    return user;
                }
            };
        }
    }*/

}
