package com.threat.sim.ErrorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OutOfMemoryErrorController {

    @GetMapping(value = "/oomerr")
    public String render(Model model) {
        model.addAttribute("title","Out of memory error");
        StringBuilder stringBuilder = new StringBuilder();
        try{
            while (true) {
                stringBuilder.append("test");
            }
        }catch (OutOfMemoryError e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}