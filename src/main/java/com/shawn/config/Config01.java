package com.shawn.config;

import com.shawn.bean.Person;
import com.shawn.service.BookService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
@Configuration //告诉Spring这是一个配置类  配置类==配置文件
//组件扫描 includeFilters：只需要哪些bean， useDefaultFilters = false 关闭默认过滤器
//包扫描、只要标注了@Controller、@Service、@Repository，@Component
@ComponentScans(
        value = {
                @ComponentScan(value="com.shawn",includeFilters = {
						@ComponentScan.Filter(type=FilterType.ANNOTATION,classes={Controller.class}),
						@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={BookService.class})
                },useDefaultFilters = false)
        }
)
//@ComponentScan  value:指定要扫描的包
//excludeFilters = Filter[] ：指定扫描的时候按照什么规则排除那些组件
//includeFilters = Filter[] ：指定扫描的时候只需要包含哪些组件
//FilterType.ANNOTATION：按照注解
//FilterType.ASSIGNABLE_TYPE：按照给定的类型；
//FilterType.ASPECTJ：使用ASPECTJ表达式
//FilterType.REGEX：使用正则指定
//FilterType.CUSTOM：使用自定义规则
public class Config01 {

    @Bean("person") //给容器中注册一个Bean;类型为返回值的类型，id默认是用方法名作为id
    public Person person(){
        return new Person("lise",20);
    }
}
