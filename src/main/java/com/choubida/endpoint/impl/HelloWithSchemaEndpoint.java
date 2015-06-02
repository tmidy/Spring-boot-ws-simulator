package com.choubida.endpoint.impl;

import choubida.com.hello.sayhello.HelloRequest;
import choubida.com.hello.sayhello.HelloResponse;
import com.choubida.configuration.template.HelloTemplateConfiguration;
import com.choubida.configuration.template.templateinterface.TemplateMapper;
import com.choubida.endpoint.ParentEndpoint;
import com.choubida.xml.XmlReader;
import com.examples.wsdl.helloservicewithschema_wsdl.HelloPortTypeWithSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tangi Midy on 21/05/2015.
 */
public class HelloWithSchemaEndpoint extends ParentEndpoint implements HelloPortTypeWithSchema, TemplateMapper {


    @Autowired
    HelloTemplateConfiguration helloTemplateConfiguration;

    @Autowired
    Jaxb2Marshaller wsMarshaller;

    @Override
    public HelloResponse sayHello(HelloRequest parameters) {

        HelloResponse response = null;

        try {

            treatRequest(parameters);
            String request = treatRequest(parameters);
            String valeur = XmlReader.readValue(request, helloTemplateConfiguration.getDesc());
            response = getResponseFromMap(valeur);

            // response.setRespond(valeur);
            treateResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     *
     * @param valeur the searched value
     * @return A Hello Response
     * @throws JAXBException
     */
    public HelloResponse getResponseFromMap(String valeur) throws JAXBException {
        HelloResponse r = null;
        String templateFile = helloTemplateConfiguration.getTemplatesResponsesMapping().get(valeur);
        if (templateFile != null) {
            r = (HelloResponse) wsMarshaller.getJaxbContext().createUnmarshaller().unmarshal(new File(templateFile));

        } else {
            templateFile = helloTemplateConfiguration.getTemplatesResponsesMapping().get("Default");
            r = (HelloResponse) wsMarshaller.getJaxbContext().createUnmarshaller().unmarshal(new File(templateFile));

        }
        return r;
    }
}
