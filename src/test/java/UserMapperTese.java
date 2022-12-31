import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.xja.phonedemo.domain.User;
import org.xja.phonedemo.mapper.UserMapper;
import org.xja.phonedemo.utils.MD5Util;
import org.xja.phonedemo.utils.MyBatisUtil;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public class UserMapperTese {
    @Test
    public void testFind(){
        SqlSession session= MyBatisUtil.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        List<User> list = userMapper.find();
        MyBatisUtil.closeSqlSession(session);

        list.forEach(user -> {
            System.out.println(user.getUserId()+"\t"+user.getUserName()+"\t"+user.getUserPhone());
        });
    }
    @Test
    public void testGet(){
        SqlSession session= MyBatisUtil.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.get(21);
        MyBatisUtil.closeSqlSession(session);

        System.out.println(user.getUserId()+"\t"+user.getUserName());
    }
    @Test
    public void testFindByNameAndPwd(){
        SqlSession session= MyBatisUtil.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.findByNameAndPwd("peter", MD5Util.MD5ToString("123456"));
        MyBatisUtil.closeSqlSession(session);

        System.out.println(user.getUserId()+"\t"+user.getUserName());
    }
    @Test
    public void testSave(){
        SqlSession session= MyBatisUtil.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUserName("jiang");
        user.setUserPass(MD5Util.MD5ToString("654321"));
        user.setUserPhone("11111111111");
        userMapper.save(user);
        session.commit();

        MyBatisUtil.closeSqlSession(session);
    }

    @Test
    public void Sample(){
        SqlSession session= MyBatisUtil.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        MyBatisUtil.closeSqlSession(session);
    }
}
