package com.pankaj.restserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {
	
    @RequestMapping(method = RequestMethod.GET, path = "/getname", produces = "text/html")
    public String getName() {
    	return "Pankaj Poshirkar";    	
    }
}