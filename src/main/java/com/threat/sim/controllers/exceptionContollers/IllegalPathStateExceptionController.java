package com.threat.sim.controllers.exceptionContollers;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.geom.GeneralPath;
import java.awt.geom.IllegalPathStateException;

@Controller
public class IllegalPathStateExceptionController {

    @GetMapping(value = "/ipse")
    public String render(Model model) {
        model.addAttribute("title","Illegal path state exception");
        try{
            GeneralPath path = new GeneralPath(GeneralPath.WIND_NON_ZERO, 10);
            path.closePath();
        }catch (IllegalPathStateException e){
            model.addAttribute("message", e);
            model.addAttribute("trace", ExceptionUtils.getStackTrace(e));
        }
        return "exception-errors";
    }
}