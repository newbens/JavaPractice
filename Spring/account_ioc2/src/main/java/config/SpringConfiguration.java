package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * 配置类
 *
 */
@Configuration//说明当前是配置类
@ComponentScan(basePackages = "cn.niuben")//有这两个注解     <context:component-scan base-package="cn.niuben"></context:component-scan> 就可以省略了
public class SpringConfiguration {
    @Bean  //作用将返回的对象放入IOC容器中。
    public QueryRunner createQr(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
    @Bean(name = "dateSource")
    public DataSource createDs() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/java?serverTimezone=Asia/Shanghai");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("nn8221002**.-");
        return druidDataSource;
    }
}
