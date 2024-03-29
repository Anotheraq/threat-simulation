package com.threat.sim.controllers.errorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class StackOverflowErrorController {

    @GetMapping(value = "/soerr")
    public String render(Model model) {
        model.addAttribute("title","Stack overflow error");
        try{
            err(Integer.MIN_VALUE);
        }catch (StackOverflowError e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
    private void err(int i){
        err(i+1);
    }
}