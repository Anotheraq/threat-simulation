package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IllegalArgumentExceptionController {

    @GetMapping(value = "/iae")
    public String render(Model model) {
        model.addAttribute("title","Illegal argument exception");
        try{
            List<Integer> i = new ArrayList<>(-1);
        }catch (IllegalArgumentException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}