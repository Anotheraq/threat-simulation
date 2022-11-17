package com.threat.sim.ErrorControllers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.NetworkInterface;
import java.net.SocketException;


@Controller
public class UnsatisfiedLinkErrorController {
    private static native NetworkInterface getByName0(String name) throws SocketException;
    @GetMapping(value = "/ulerr")
    public String render(Model model) {
        model.addAttribute("title","Unsatisfied link error");
        try{
            getByName0(" ");
        }catch (UnsatisfiedLinkError | SocketException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}