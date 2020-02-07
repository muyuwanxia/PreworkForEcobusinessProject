package com.seu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix="spring.datasource")
    @Bean
    public DataSource druidDatasource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean staViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //登录
        HashMap<String,String>initParameters=new HashMap<>();
        initParameters.put("loginUsername","druid");
        initParameters.put("loginPassword","druid");
        //访问限制
        initParameters.put("allow","localhost");
        bean.setInitParameters(initParameters);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        //过滤css、js
        Map<String, String> initParams = new HashMap<>();
        initParams.put("exclusions", "*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
