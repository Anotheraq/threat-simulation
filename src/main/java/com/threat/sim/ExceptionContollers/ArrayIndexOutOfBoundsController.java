package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArrayIndexOutOfBoundsController {

    @GetMapping(value = "/aioob")
    public String render(Model model) {
        model.addAttribute("title","Array index out of bounds exception");

        char x[] = new char[1];
        try{
            x[1]='a';
        }catch (ArrayIndexOutOfBoundsException e){
            model.addAttribute("exception", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }

        return "exception-errors";
    }
}