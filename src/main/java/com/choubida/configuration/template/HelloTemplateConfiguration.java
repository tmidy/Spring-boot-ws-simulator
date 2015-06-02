package com.choubida.configuration.template;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.HashMap;

/**
 * Created by Tangi Midy on 07/05/2015.
 */
@Component
@ConfigurationProperties(locations = "classpath:hello.yml")
public class HelloTemplateConfiguration {

    private String desc;

    private static final String PREFIX = "Reponse_";

    // Path to the templates
    private String responsesTemplates;

    private HashMap<String, String> templatesResponsesMapping = new HashMap<String, String>();

    public String getDesc() {

        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
            String key = f.getName().split(PREFIX)[1];
            templatesResponsesMapping.put(key, f.getAbsolutePath());
        }
    }

    public HashMap<String, String> getTemplatesResponsesMapping() {
        return templatesResponsesMapping;
    }
}
