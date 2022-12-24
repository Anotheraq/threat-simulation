package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArithmeticalExceptionController {

    @GetMapping(value = "/ae")
    public String render(Model model) {
        model.addAttribute("title","Arithmetical exception");

        int x;
        try{
            x = 1/0;
        }catch (ArithmeticException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }

        return "exception-errors";
    }
}