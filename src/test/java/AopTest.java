import com.shawn.config.Config05;
import com.shawn.service.MathCalculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description TODO
 * @Author shawn
 * @create 2019/1/23 0023
 */
public class AopTest {
    @Test
    public void test01() {
        //必须从容器中获取Bean
//        MathCalculator mathCalculator = new MathCalculator();
//        int i = mathCalculator.div(6,2);
//        System.out.println(i);
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config05.class);
        MathCalculator mathCalculator = (MathCalculator) ac.getBean("calculator");
        mathCalculator.div(6, 0);

    }
}
