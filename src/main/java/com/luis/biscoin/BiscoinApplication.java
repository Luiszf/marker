package com.luis.biscoin;

import jdk.jfr.ContentType;
import net.minidev.json.JSONObject;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityDataConfiguration;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.net.http.HttpResponse;
import java.util.Collections;
import java.util.Map;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BiscoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiscoinApplication.class,args);
	}

}
