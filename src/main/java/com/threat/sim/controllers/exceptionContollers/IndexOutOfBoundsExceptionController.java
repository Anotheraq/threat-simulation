package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class IndexOutOfBoundsExceptionController {

    @GetMapping(value = "/ioobe")
    public String render(Model model) {
        model.addAttribute("title","Index out of bounds exception");
        try{
            new ArrayList<Integer>().get(1);
        }catch (IndexOutOfBoundsException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}