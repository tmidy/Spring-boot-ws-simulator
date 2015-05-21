package com.choubida.configuration.template;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by tmidy on 07/05/2015.
 */
@Component
@ConfigurationProperties(locations = "classpath:hello.yml")
public class HelloTemplateConfiguration {


   /* // Path to the templates
    private String responsesTemplates;

    // Valeur Pivot
    private List<String> arpDesc = new ArrayList<String>();

    private HashMap<String, String> templatesResponsesMapping = new HashMap<String, String>();

    public List<String> getArpDesc() {
        return arpDesc;
    }

    public String getResponsesTemplates() {
        return responsesTemplates;
    }

    public void setResponsesTemplates(String responsesTemplates) {
        this.responsesTemplates = responsesTemplates;
    }

    @PostConstruct
    @Async
    public void initTemplatesList() {
        for (File f : new File(getResponsesTemplates()).listFiles()) {
            String key = f.getName().split("Reponse_")[1];
            templatesResponsesMapping.put(key, f.getAbsolutePath());
        }
    }

    public HashMap<String, String> getTemplatesResponsesMapping() {
        return templatesResponsesMapping;
    }*/
}
