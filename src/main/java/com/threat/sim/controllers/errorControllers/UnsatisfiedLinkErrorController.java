package com.threat.sim.controllers.errorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.NetworkInterface;
import java.net.SocketException;


@Controller
public class UnsatisfiedLinkErrorController {

    static class Test{
        private static String a = "Anti NoClassDefFoundError string";
        static {
            System.loadLibrary("libFile");
        }
    }
    @GetMapping(value = "/ulerr")
    public String render(Model model) {
        model.addAttribute("title","Unsatisfied link error");
        try{
            new Test();
        }catch (UnsatisfiedLinkError e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}