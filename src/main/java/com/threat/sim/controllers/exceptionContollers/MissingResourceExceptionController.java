package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

@Controller
public class MissingResourceExceptionController {


    @GetMapping(value = "/mre")
    public String render(Model model) {
        model.addAttribute("title","Missing resource exception");
        try{
            ResourceBundle.getBundle("a");
        }catch (MissingResourceException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}