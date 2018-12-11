package org.superbiz.struts;

import org.apache.struts2.dispatcher.FilterDispatcher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

   /* @Bean
    public FilterDispatcher struts2() {
        return new FilterDispatcher(actionServlet, "/moviefun/*");
    }*/


    @Bean
    public FilterRegistrationBean struts2() {
        FilterRegistrationBean filterRegistrationBean= new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new org.apache.struts2.dispatcher.FilterDispatcher());
        Map<String,String> initparamMap=new HashMap<String,String>();
        initparamMap.put("actionPackages","com.lq");
        filterRegistrationBean.setInitParameters(initparamMap);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean struts_cleanup() {

        FilterRegistrationBean filterRegistrationBean= new FilterRegistrationBean();

        filterRegistrationBean.setFilter(new org.apache.struts2.dispatcher.ActionContextCleanUp());

        return filterRegistrationBean;
    }


    @Bean
    public FilterRegistrationBean sitemesh() {
        FilterRegistrationBean filterRegistrationBean= new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new com.opensymphony.module.sitemesh.filter.PageFilter());

        return filterRegistrationBean;
    }




}
