package com.example.todowebapp.login;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class WelcomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model){
        model.put("name", getLoggedInUsername());

        return "welcome";
    }

    public String getLoggedInUsername(){
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
    

}
