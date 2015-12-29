package ssm;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oneler.mybatis.dao.UserMapper;
import com.oneler.mybatis.models.User;
public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader    = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    public static void main(String[] args) {
    	SqlSession session = sqlSessionFactory.openSession();
    	  try {
    	    /*    User user = (User) session.selectOne("com.oneler.mybatis.dao.UserMapper.selectByPrimaryKey", 1);
    	        System.out.println(user.getUseraddress());
    	        System.out.println(user.getUsername());*/
    	      UserMapper mapper = session.getMapper(UserMapper.class);
    	      User user =mapper.selectByPrimaryKey(1);
    	      System.out.println(user.getUseraddress());
              System.out.println(user.getUsername());
    	        } finally {
    	        session.close();
    	        }
    	    }
}