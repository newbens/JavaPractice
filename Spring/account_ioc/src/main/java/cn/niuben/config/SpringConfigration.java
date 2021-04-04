package cn.niuben.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration //表明当前是配置类
@ComponentScan(basePackages = "cn.niuben")  //指定要扫描的包
@PropertySource("classpath:Jdbc.properties")
public class SpringConfigration {
    @Value("${jdbc.driver}")
    String drivername;
    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean(name = "runner") //把当前方法的返回值存入IOC容器
    @Scope("prototype")
    public QueryRunner createRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }
    @Bean(name = "dataSource")
    public DataSource createDatasource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(drivername);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }
}
