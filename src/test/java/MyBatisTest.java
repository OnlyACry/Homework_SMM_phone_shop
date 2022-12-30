import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.xja.phonedemo.utils.MyBatisUtil;

public class MyBatisTest {
    @Test
    public void test1()
    {
        SqlSession session = MyBatisUtil.createSqlSession();
        System.out.println(session);
        MyBatisUtil.closeSqlSession(session);
    }
}
