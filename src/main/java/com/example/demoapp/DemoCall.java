package com.example.demoapp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoCall {
    @Value("${foo.bar}")
    private String foobar;

    @GetMapping("/demo")
    public Map<String, String> demo() {

        HashMap<String, String> map = new HashMap<>();
        map.put("foo.bar",foobar);
        return map;
    }
}