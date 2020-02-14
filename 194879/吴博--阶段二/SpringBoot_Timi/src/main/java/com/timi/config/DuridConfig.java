package com.timi.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
public class DuridConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean monitor(){
        ServletRegistrationBean<StatViewServlet> Sbean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台登陆配置
        HashMap<String,String> hashMap = new HashMap<>();
        //增加配置
        hashMap.put("loginUsername","admin");
        hashMap.put("loginPassword","123456");
        //允许谁访问
        hashMap.put("allow","");
        //禁止访问
        hashMap.put("id","主机名");
        Sbean.setInitParameters(hashMap);
        return Sbean;
    }
}
