package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class IllegalStateExceptionController {

    @GetMapping(value = "/ise")
    public String render(Model model) {
        model.addAttribute("title","Illegal state exception");
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4));
        Iterator<Integer> it = numbers.iterator();
        try{
            while(it.hasNext()){
                it.remove();
            }
        }catch (IllegalStateException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}