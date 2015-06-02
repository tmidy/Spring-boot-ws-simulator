package com.choubida.endpoint.impl;

import choubida.com.hello.sayhello.HelloResponse;
import com.choubida.endpoint.ParentEndpoint;
import com.examples.wsdl.helloservice_wsdl.HelloPortType;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Tangi Midy on 21/05/2015.
 */
public class HelloEndpoint extends ParentEndpoint implements  HelloPortType{


    @Override
    public String sayHello(String firstName) {
        return "Hello " + firstName;
    }




}
