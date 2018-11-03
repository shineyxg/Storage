package com.shine.storage.rest.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : shine
 * @Project: Storage
 * @Description:
 * @date: 2018年10月21日 15:58
 */
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping
    public String testController(){
        return "请求成功！";
    }
}
