package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UnsupportedOperationExceptionController {

    @GetMapping(value = "/uoe")
    public String render(Model model) {
        model.addAttribute("title","Unsupported operation exception");
        List<Integer> numbers = Arrays.asList(1,2,3);
        try{
            numbers.add(4);
        }catch (UnsupportedOperationException e){
            model.addAttribute("exception", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}