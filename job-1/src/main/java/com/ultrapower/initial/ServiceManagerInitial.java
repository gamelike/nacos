package com.ultrapower.initial;

import com.alibaba.cloud.nacos.NacosServiceManager;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.ServiceInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author violet
 * @since 2024/8/25
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class ServiceManagerInitial implements ApplicationRunner {
    private final NacosServiceManager nacosServiceManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("--initial nacos management--");
        NamingService namingService = nacosServiceManager.getNamingService();
        List<ServiceInfo> subscribeServices = namingService.getSubscribeServices();
        for (ServiceInfo subscribeService : subscribeServices) {
            log.info("subscribe-service: {}", subscribeService);
        }
    }
}
