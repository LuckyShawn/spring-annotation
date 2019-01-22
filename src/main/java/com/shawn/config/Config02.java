package com.shawn.config;

import com.shawn.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
@Configuration
public class Config02 {


    //默认是单实例的
    /**
     * @see ConfigurableBeanFactory#SCOPE_PROTOTYPE     prototype
     * @see ConfigurableBeanFactory#SCOPE_SINGLETON     singleton
     * @see //org.springframework.web.context.WebApplicationContext SCOPE_REQUEST
     * @see //org.springframework.web.context.WebApplicationContext SCOPE_SESSION
     * @Scope:调整作用域
     * prototype：多实例的：ioc容器启动并不会去调用方法创建对象放在容器中。
     * 					每次获取的时候才会调用方法创建对象；
     * singleton：单实例的（默认值）：ioc容器启动会调用方法创建对象放到ioc容器中。
     * 			以后每次获取就是直接从容器（map.get()）中拿，
     *
     * 	Web环境下：
     * request：同一次请求创建一个实例
     * session：同一个session创建一个实例
     *
     * 懒加载：
     * 		单实例bean：默认在容器启动的时候创建对象；
     * 		懒加载：容器启动不创建对象。第一次使用(获取)Bean创建对象，并初始化；
     *
     */
    //@Lazy
    @Scope("prototype")
    @Bean("person")
    public Person person(){
        return new Person("jack",18);
    }


    /**
     * @Conditional({Condition}) ： 按照一定的条件进行判断，满足条件给容器中注册bean
     *
     * 如果系统是windows，给容器中注册("bill")
     * 如果是linux系统，给容器中注册("linus")
     */

    @Bean("bill")
    public Person person01(){
        return new Person("Bill Gates",62);
    }

    //@Conditional("linus")
    @Bean("linus")
    public Person person02(){
        return new Person("linus", 48);
    }

}
