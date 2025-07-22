package com.sauce.agua.report.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableFeignClients(basePackages = "com.sauce.agua.report.client")
@PropertySource("classpath:config/reports.properties")
public class ReportConfiguration {
}
