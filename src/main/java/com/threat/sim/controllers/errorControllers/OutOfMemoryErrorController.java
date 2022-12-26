package com.threat.sim.controllers.errorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class OutOfMemoryErrorController {

    @GetMapping(value = "/oomerr")
    public String render(Model model) {
        model.addAttribute("title","Out of memory error");
        List<Integer> numbers = new ArrayList<>();
        try{
            while (true) {
                numbers.add(1);
            }
        }catch (OutOfMemoryError e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}