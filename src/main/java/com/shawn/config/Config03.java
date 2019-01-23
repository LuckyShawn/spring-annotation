package com.shawn.config;

import com.shawn.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/23 0023
 */
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中;加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value={"classpath:/person.properties"})
@Configuration
public class Config03 {

    @Bean
    public Person person(){
        return new Person();
    }

}
