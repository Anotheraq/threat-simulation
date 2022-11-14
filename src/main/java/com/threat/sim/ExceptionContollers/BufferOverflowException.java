package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.ByteBuffer;

@Controller
public class BufferOverflowException {

    @GetMapping(value = "/bo")
    public String render(Model model) {
        model.addAttribute("title","Buffer overflow exception");

        ByteBuffer bf = ByteBuffer.allocate(1);
        try{
            bf.putInt(1);
        }catch (java.nio.BufferOverflowException e){
            model.addAttribute("exception", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}