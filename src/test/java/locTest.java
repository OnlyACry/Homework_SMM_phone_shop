import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xja.phonedemo.domain.User;
import org.xja.phonedemo.mapper.UserMapper;

public class locTest {
    @Test
    public void test1()
    {
        User user=new User();
        user.setUserId(100);
        user.setUserName("张三");
        System.out.println(user);
    }
    @Test
    public void test2()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        User u = (User)context.getBean("user");
        System.out.println(u);
    }
    @Test
    public void test3()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        SqlSessionFactory sf = (SqlSessionFactory)context.getBean("sf");
        System.out.println(sf.openSession(false));
    }
    @Test
    public void test4()
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-ioc.xml");
        UserMapper userMapper = (UserMapper)context.getBean("userMapper");
        userMapper.find();

    }
}
