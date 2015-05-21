package com.choubida.endpoint.impl;

import choubida.com.hello.sayhello.HelloRequest;
import choubida.com.hello.sayhello.HelloResponse;
import com.choubida.endpoint.ParentEndpoint;
import com.examples.wsdl.helloservice_wsdl.HelloPortType;
import com.examples.wsdl.helloservicewithschema_wsdl.HelloPortTypeWithSchema;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by tmidy on 21/05/2015.
 */
public class HelloWithSchemaEndpoint extends ParentEndpoint implements HelloPortTypeWithSchema{

    @Override
    public HelloResponse sayHello(HelloRequest parameters) throws ParserConfigurationException, JAXBException, SAXException, IOException {
        treatRequest(parameters);
        HelloResponse response = new HelloResponse();
        response.setRespond("Hello" + parameters.getSayHi());
        treateResponse(response);
        return response;
    }
}
