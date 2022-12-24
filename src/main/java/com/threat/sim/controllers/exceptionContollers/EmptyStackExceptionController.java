package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.EmptyStackException;
import java.util.Stack;

@Controller
public class EmptyStackExceptionController {

    @GetMapping(value = "/ese")
    public String render(Model model) {
        model.addAttribute("title","Empty stack exception");
        Stack stack = new Stack();
        try{
            stack.pop();
        }catch (EmptyStackException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}