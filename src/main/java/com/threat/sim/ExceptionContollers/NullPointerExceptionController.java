package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NullPointerExceptionController {


    @GetMapping(value = "/npe")
    public String render(Model model) {
        model.addAttribute("title","Null pointer exception");
        try{
            String el = null;
            el.substring(1,2);
        }catch (NullPointerException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}