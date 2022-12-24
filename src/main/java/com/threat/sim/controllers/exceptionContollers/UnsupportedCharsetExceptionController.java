package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

@Controller
public class UnsupportedCharsetExceptionController {


    @GetMapping(value = "/uce")
    public String render(Model model) {
        model.addAttribute("title","Unsupported charset exception");
        try{
            Charset.forName("test");
        }catch (UnsupportedCharsetException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}