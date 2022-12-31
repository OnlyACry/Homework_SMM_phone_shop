import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.xja.phonedemo.domain.User;
import org.xja.phonedemo.service.UserService;
import org.xja.phonedemo.service.impl.UserServiceimpl;
import org.xja.phonedemo.utils.MD5Util;
import org.xja.phonedemo.utils.MyBatisUtil;
import java.util.List;

@Service
public class UserServiceTest {
    UserService userService=new UserServiceimpl();

    @Before
    public void init() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        userService = (UserService) context.getBean("userService");
    }
    @Test
    public void testLogin()
    {
        User user = userService.login("peter", "123456");
        if(user!=null){
            System.out.println("登陆成功"+user.getUserPhone());
        }else{
            System.out.println("登陆失败");
        }
    }
    @Test
    public void testReg(){
        User user = new User();
        user.setUserName("jiang");
        user.setUserPass(MD5Util.MD5ToString("654321"));
        user.setUserPhone("11111111111");
        userService.reg(user);

    }
    @Test
    public void testFind(){
        PageHelper.startPage(2,5);
        List<User> list=userService.showUsers();
        PageInfo<User> pv=new PageInfo<User>(list);
        System.out.println("当前页号:");
        System.out.println(pv.getPageNum());
        System.out.println("每页记录数:");
        System.out.println(pv.getPageSize());
        System.out.println("总页数:");
        System.out.println(pv.getPages());
        System.out.println("当前页的用户:");
        pv.getList().forEach(user -> {
            System.out.println(user.getUserId()+"\t"+user.getUserName()+"\t"+user.getUserPhone());
        });
    }
}
