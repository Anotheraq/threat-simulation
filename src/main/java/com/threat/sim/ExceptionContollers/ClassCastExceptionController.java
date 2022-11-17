package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassCastExceptionController {

    @GetMapping(value = "/cce")
    public String render(Model model) {
        model.addAttribute("title","Class cast exception");
        Object a = 1;
        try{
            String x = (String) a;
        }catch (ClassCastException e){
            model.addAttribute("exception", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}