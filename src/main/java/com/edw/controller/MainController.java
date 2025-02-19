package com.edw.controller;

import com.edw.bean.User;
import org.infinispan.Cache;
import org.infinispan.manager.EmbeddedCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


/**
 * <pre>
 *  com.edw.controller.MainController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 19 Feb 2025 10:20
 */
@RestController
public class MainController {

    @Autowired
    private EmbeddedCacheManager cacheManager;

    @GetMapping(path = "/")
    public HashMap index() {
        return new HashMap(){{
            put("hello", "world");
        }};
    }

    @GetMapping(path = "/get-user/{key}")
    public ResponseEntity getUser(@PathVariable String key) {
        Cache myCache = cacheManager.getCache("user-cache");
        return ResponseEntity.ok((User)myCache.getOrDefault(key, new User()));
    }

    @GetMapping(path = "/add-user")
    public ResponseEntity addUsers(@RequestParam String name,
                                   @RequestParam Integer age,
                                   @RequestParam String address,
                                   @RequestParam String province) {
        cacheManager.getCache("user-cache").put(name, new User(name, age, address, province));
        return ResponseEntity.ok((User) cacheManager.getCache("user-cache").getOrDefault(name, new User()));
    }
}