package com.choubida.endpoint;

import choubida.com.hello.sayhello.HelloResponse;
import com.choubida.configuration.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * parent Class for each endpoint
 */
@Service
public class ParentEndpoint {

    @Autowired
    PropertiesConfiguration propertiesConfiguration;

    @Autowired
    Jaxb2Marshaller wsMarshaller;

    static final Logger LOG = LoggerFactory.getLogger(ParentEndpoint.class);

    private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyyMMdd HHmmss");
        }
    };

    public String formatIt(Date date)
    {
        return formatter.get().format(date);
    }

    public String treatRequest(Object request) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        LOG.info("Reveceived request of type {}", request.getClass().getSimpleName());
        return marshal(request, 1);
    }

    public void treateResponse(Object response) throws IOException, JAXBException, ParserConfigurationException, SAXException {
        LOG.info("marshalling response of type {}", response.getClass().getSimpleName());
       marshal(response, 2);
    }

    public <T>  String marshal(T object, Integer mode) throws IOException, SAXException, ParserConfigurationException {
        File f;
        if (mode == 1) {
            f = new File(propertiesConfiguration.getInput() + "Request" + object.getClass().getSimpleName() + "_" + formatIt(new Date()) + ".xml");
        } else {
            f = new File(propertiesConfiguration.getOutput() + "Response_" + object.getClass().getSimpleName() + "_" + formatIt(new Date()) + ".xml");
        }
        FileWriter w = new FileWriter(f);
        StringWriter stringResult=new StringWriter();
        StreamResult res = new StreamResult(stringResult);
        wsMarshaller.marshal(object, res);
        w.write(stringResult.toString());
        w.close();

        return stringResult.toString();
    }





}
