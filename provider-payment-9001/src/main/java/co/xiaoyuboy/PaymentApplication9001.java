package co.xiaoyuboy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: Smile
 * @Date: 2024-05-24 14:56
 * @Description:
 */
@SpringBootApplication
@MapperScan("co.xiaoyuboy.mapper")
public class PaymentApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class,args);
    }
}
