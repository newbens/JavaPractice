package JDBC.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws  Exception{
        //1.����jar��
        //2.���������ļ�
        //3.���������ļ�
        Properties pro = new Properties();
        InputStream is = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        //4.��ȡ���ӳض���
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        //5.��ȡ����
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();
    }
}
