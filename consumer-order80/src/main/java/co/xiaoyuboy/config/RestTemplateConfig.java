package co.xiaoyuboy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @auther Smile
 * @create 2024-5-26 22:32
 */
@Configuration
public class RestTemplateConfig
{
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
