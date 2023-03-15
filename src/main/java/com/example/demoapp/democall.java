package com.example.demoapp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class democall {
    @Value("${foo.bar}")
    private String foobar;

    @RequestMapping("/demo")
    public Map<String, String> demo() {

        HashMap<String, String> map = new HashMap<>();
        map.put("foo.bar",foobar);
        return map;
    }
}