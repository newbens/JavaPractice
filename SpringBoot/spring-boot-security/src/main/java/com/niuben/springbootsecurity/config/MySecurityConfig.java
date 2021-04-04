package com.niuben.springbootsecurity.config;


import com.sun.org.apache.xpath.internal.operations.And;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");
        //开启自动配置的登陆功能
        http.formLogin().loginPage("/userlogin"); //自定义登录页
        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");//注销成功后，跳转的页面
        //记住我功能
        http.rememberMe();//登录成功后，将cookies发给浏览器保存，如果点击注销浏览器会删除cookie

    }
    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("niuben")
                .password(new BCryptPasswordEncoder().encode("nn8221002**.-"))
                .roles("VIP1","VIP2");
    }
}
