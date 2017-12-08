package cn.stt.cloud.study.controller;

import cn.stt.cloud.study.entity.User;
import cn.stt.cloud.study.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author shitongtong
 * <p>
 * Created by shitongtong on 2017/12/5.
 */
@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @GetMapping("/ribbon/{id}")
    public User findById(@PathVariable Long id) {
        return ribbonService.findById(id);
    }
}
