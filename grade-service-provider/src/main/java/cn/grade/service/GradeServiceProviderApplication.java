package cn.grade.service;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringCloudApplication
@EnableDiscoveryClient
@EnableJpaRepositories
@EnableSwagger2Doc
public class GradeServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(GradeServiceProviderApplication.class, args);
    }
}
