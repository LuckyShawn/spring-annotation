import com.shawn.bean.Blue;
import com.shawn.bean.Person;
import com.shawn.config.Config01;
import com.shawn.config.Config02;
import com.shawn.config.Config03;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class PersonTest {
    AnnotationConfigApplicationContext applicationContext = null;
    //利用配置文件的方式
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }

    //配置类的方式
    @Test
    public void test02(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config01.class);
        Person person = (Person) ac.getBean("person");
        System.out.println(person);
    }

    //测试注解扫描和扫描过滤
    @Test
    public void test03(){
        applicationContext = new AnnotationConfigApplicationContext(Config01.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    //测试组件作用域
    @Test
    public void test04(){
        applicationContext = new AnnotationConfigApplicationContext(Config02.class);
        String [] names = applicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        Object person01 = applicationContext.getBean("person");
        Object person02 = applicationContext.getBean("person");
        System.out.println(person01 == person02);
        //true 返回的是同一个实例

    }

    //测试@Conditional
    @Test
    public void test05(){
        applicationContext = new AnnotationConfigApplicationContext(Config02.class);
        //获取所有Person类型的bean
        String[] namesForType = applicationContext.getBeanNamesForType(Person.class);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        //动态获取环境变量的值；Windows 10
        String property = environment.getProperty("os.name");
        System.out.println(property);
        for (String name : namesForType) {
            System.out.println(name);
        }
        Map<String, Person> persons = applicationContext.getBeansOfType(Person.class);
        System.out.println(persons);
    }

    //测试@Import
    @Test
    public void test06(){
        applicationContext = new AnnotationConfigApplicationContext(Config02.class);
        printBeans(applicationContext);
        Blue bean = applicationContext.getBean(Blue.class);
        System.out.println(bean);

        //工厂Bean获取的是调用getObject创建的对象
        Object bean2 = applicationContext.getBean("colorFactoryBean");
        Object bean3 = applicationContext.getBean("colorFactoryBean");
        System.out.println("bean的类型："+bean2.getClass());
        System.out.println(bean2 == bean3);

        Object bean4 = applicationContext.getBean("&colorFactoryBean");
        System.out.println(bean4.getClass());
    }
    //打印bean信息
    private void printBeans(AnnotationConfigApplicationContext applicationContext){
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }


    //测试@Value
    @Test
    public void test07(){
        applicationContext = new AnnotationConfigApplicationContext(Config03.class);
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);
    }
}
