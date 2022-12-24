package com.threat.sim.controllers.errorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AssertionErrorController {

    @GetMapping(value = "/aerr")
    public String render(Model model) {
        model.addAttribute("title","Assertion error");
        try{
            Assertions.assertEquals(2,4);
        }catch (AssertionError e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}