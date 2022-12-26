package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexOutOfBoundsExceptionController {

    @GetMapping(value = "/ioobe")
    public String render(Model model) {
        model.addAttribute("title","Index out of bounds exception");
        List<Integer> num = new ArrayList<>(List.of(1));
        try{
            num.get(-1);
        }catch (IndexOutOfBoundsException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}