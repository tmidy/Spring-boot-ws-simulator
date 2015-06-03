package com.choubida.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

/**
 * Created by Tangi Midy on 02/06/2015.
 */
@RestController
@RequestMapping("/hello")
public class HelloResource {

    static final Logger LOG = LoggerFactory.getLogger(HelloResource.class);

    @RequestMapping(value = "/sayHi",
            method = RequestMethod.POST)
    public String greeting(@RequestParam(value = "userName", defaultValue = "PEGA") @Valid final String userName) {
        return "Hello " + userName;
    }

}

