import com.shawn.bean.Person;
import com.shawn.config.Config01;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/22 0022
 */
public class PersonTest {

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

    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config01.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }
}
