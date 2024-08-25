package com.ultrapower.thread;

import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author violet
 * @since 2024/8/26
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class ServiceManagementThread implements ApplicationRunner {
    private final NacosServiceManager nacosServiceManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        NamingService namingService = nacosServiceManager.getNamingService();
        try {
            namingService.subscribe("job-2", event -> {
                if (event instanceof NamingEvent) {
                    log.info("服务发生状态变更: {}", ((NamingEvent) event).getServiceName());
                }
            });
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }
}
