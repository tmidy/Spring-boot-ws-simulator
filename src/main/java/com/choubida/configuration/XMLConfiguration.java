package com.choubida.configuration;

import choubida.com.hello.sayhello.HelloRequest;
import choubida.com.hello.sayhello.HelloResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tmidy on 30/03/2015.
 */
@Configuration
public class XMLConfiguration {

    /* Shared JAXB marshaller/unmarshaller instance
    * @return The marshaller/unmarshaller instance
    */
    @Bean(name = "wsMarshaller")
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setMtomEnabled(true);
        marshaller.setClassesToBeBound(String.class, HelloRequest.class, HelloResponse.class);
        Map props = new HashMap<String, Object>();
        props.put("jaxb.formatted.output", true);
        marshaller.setMarshallerProperties(props);
        marshaller.setCheckForXmlRootElement(true);

        return marshaller;
    }

}
