package jp.spring.learn.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "jp.spring.learn" })
public class ApplicationConfig {

}
