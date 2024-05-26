package co.xiaoyuboy;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Smile
 * @Date: 2024-05-24 14:56
 * @Description:
 */
@SpringBootApplication
@EnableKnife4j
@MapperScan("co.xiaoyuboy.mapper")
//开启服务发现
@EnableDiscoveryClient
public class PaymentApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class,args);
    }
}
