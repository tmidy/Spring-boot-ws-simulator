package com.choubida;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@EnableWs
@Configuration
@ImportResource("spring/cxf.xml")
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean(name = "servletRegistrationBean")
    public ServletRegistrationBean cxfServlet() {
        ServletRegistrationBean servletDef = new ServletRegistrationBean(new CXFServlet(), "/ws/*");
        servletDef.setLoadOnStartup(1);

        return servletDef;
    }
}
