package com.threat.sim.ErrorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ExceptionInInitializerErrorController {

    static class TestClass{
        private static int testVar;
        static{
            testVar = 2/0;
        }
    }
    @GetMapping(value = "/eiierr")
    public String render(Model model) {
        model.addAttribute("title","Exception in initializer error");
        try{
            new TestClass();
        }catch (ExceptionInInitializerError e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}