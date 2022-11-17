package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NegativeArraySizeExceptionController {

    @GetMapping(value = "/nase")
    public String render(Model model) {
        model.addAttribute("title","Negative array size exception");
        try{
            int[] i = new int[-1];
        }catch (NegativeArraySizeException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}