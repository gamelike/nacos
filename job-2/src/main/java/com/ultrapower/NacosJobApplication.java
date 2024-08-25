package com.ultrapower;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author violet
 * @since 2024/8/25
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class NacosJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosJobApplication.class, args);
    }

    @RestController
    static class TestController {
        @GetMapping("echo/{echo}")
        public ResponseEntity<String> echo(@PathVariable("echo") String echo) {
            return ResponseEntity.ok(echo);
        }
    }
}
