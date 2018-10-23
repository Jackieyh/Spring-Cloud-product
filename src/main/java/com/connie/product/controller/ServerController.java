package com.connie.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 普通类
 *
 * @Author:Jackie
 * @Date:Created in 2018-10-23 09:37:01
 */
@RestController
public class ServerController {

    @GetMapping("/msg")
    public String msg() {
        return "this is product msg";
    }
}
