package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NumberFormatExceptionController {


    @GetMapping(value = "/nfe")
    public String render(Model model) {
        model.addAttribute("title","Number format exception");
        try{
            Integer.valueOf("test");
        }catch (NumberFormatException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}