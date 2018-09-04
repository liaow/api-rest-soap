package com.github.saharag.api.service.config;

import com.github.saharag.api.service.constant.InterfaceConstant;
import com.github.saharag.api.service.ws.DemoEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

import javax.xml.ws.Endpoint;

/**
 * @author liao
 * @date 2018/8/10
 */
@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    /**
     * 定义ws请求的servlet，以及映射路径
     *
     * @param applicationContext
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherServlet(ApplicationContext applicationContext) {
        /*MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);*/
        CXFServlet servlet = new CXFServlet();
        return new ServletRegistrationBean(servlet, InterfaceConstant.WS_URL_MAPPINGS);
    }

    /**
     * 定义rest请求的servlet，以及映射路径
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean dispatcherRestServlet() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.scan("com.github.saharag.api.service.rest");
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings(InterfaceConstant.REST_URL_MAPPINGS);
        registrationBean.setName("rest");
        return registrationBean;
    }


    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public DemoEndpoint demoEndpoint() {
        return new DemoEndpoint();
    }

    /**
     * 定义endpoint
     *
     * @return
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), demoEndpoint());
        endpoint.publish("/");
        return endpoint;
    }
}