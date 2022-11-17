package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

@Controller
public class ConcurrentModificationExceptionController {

    @GetMapping(value = "/cme")
    public String render(Model model) {
        model.addAttribute("title","Concurrent modification exception");
        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4));
        try{
            for(Integer i: numbers){
                if(i%2==0){
                    numbers.remove(i);
                }
            }
        }catch (ConcurrentModificationException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}