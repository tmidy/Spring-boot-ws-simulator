package com.choubida.configuration.template.templateinterface;

import javax.xml.bind.JAXBException;

/**
 * Created by tangi midy on 02/06/2015.
 */
public interface TemplateMapper {

    /**
     * Returns the template associated reponse
     * @param valeur the searched value
     * @param <T> the Response to return
     */
    public <T> Object getResponseFromMap(String valeur) throws JAXBException;

}
