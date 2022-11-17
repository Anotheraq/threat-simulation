package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.InputMismatchException;
import java.util.Scanner;

@Controller
public class InputMismatchExceptionController {

    @GetMapping(value = "/ime")
    public String render(Model model) {
        model.addAttribute("title","Input mismatch exception");
        Scanner scanner = new Scanner("string");
        try{
            scanner.nextInt();
        }catch (InputMismatchException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}