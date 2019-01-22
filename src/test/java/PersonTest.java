import com.shawn.bean.Person;
import com.shawn.config.Config01;
import com.shawn.config.Config02;
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

    //测试注解扫描和扫描过滤
    @Test
    public void test03(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config01.class);
        String[] definitionNames = applicationContext.getBeanDefinitionNames();
        for (String name : definitionNames) {
            System.out.println(name);
        }
    }

    //测试组件作用域
    @Test
    public void test04(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config02.class);
        String [] names = applicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        Object person01 = applicationContext.getBean("person");
        Object person02 = applicationContext.getBean("person");
        System.out.println(person01 == person02);
        //true 返回的是同一个实例

    }
}
