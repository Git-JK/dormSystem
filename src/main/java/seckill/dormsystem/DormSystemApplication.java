package seckill.dormsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("seckill.dormsystem.dao")
public class DormSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DormSystemApplication.class, args);
    }

}
