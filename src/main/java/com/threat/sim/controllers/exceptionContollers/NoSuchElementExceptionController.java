package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class NoSuchElementExceptionController {
    @GetMapping(value = "/nsee")
    public String render(Model model) {
        model.addAttribute("title","No such element exception");
        List<Integer> empty = new ArrayList<>();
        Iterator<Integer> it = empty.iterator();
        try{
            it.next();
        }catch (NoSuchElementException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}