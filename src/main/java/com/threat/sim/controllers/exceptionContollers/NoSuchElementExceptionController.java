package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Controller
public class NoSuchElementExceptionController {


    @GetMapping(value = "/nsee")
    public String render(Model model) {
        model.addAttribute("title","No such element exception");
        try{
            new ArrayList<Integer>().iterator().next();
        }catch (NoSuchElementException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}