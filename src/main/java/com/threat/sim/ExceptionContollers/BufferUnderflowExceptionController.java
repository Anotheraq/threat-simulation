package com.threat.sim.ExceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.nio.ByteBuffer;
@Controller
public class BufferUnderflowExceptionController {

    @GetMapping(value = "/bu")
    public String render(Model model) {
        model.addAttribute("title","Buffer underflow exception");
        ByteBuffer bf = ByteBuffer.allocate(1);
        try{
            bf.getInt();
        }catch (java.nio.BufferUnderflowException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}