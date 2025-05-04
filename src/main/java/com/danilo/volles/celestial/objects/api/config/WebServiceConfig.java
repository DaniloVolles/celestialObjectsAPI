package com.danilo.volles.celestial.objects.api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context) {
        var servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "celestialObjects")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema celestialObjectsSchema) {
        var wsdl = new DefaultWsdl11Definition();
        wsdl.setPortTypeName("CelestialObjectsPort");
        wsdl.setLocationUri("/ws");
        wsdl.setTargetNamespace("http://www.danilovolles.com/celestialObjects");
        wsdl.setSchema(celestialObjectsSchema);
        return wsdl;
    }

    @Bean
    public XsdSchema celestialObjectsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/celestialObjects.xsd"));
    }

}
