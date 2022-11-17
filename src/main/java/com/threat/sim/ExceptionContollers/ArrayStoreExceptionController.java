package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArrayStoreExceptionController {

    @GetMapping(value = "/as")
    public String render(Model model) {
        model.addAttribute("title","Array store exception");

        Object x[] = new Character[1];
        try{
            x[0]=1;
        }catch (java.lang.ArrayStoreException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }

        return "exception-errors";
    }
}