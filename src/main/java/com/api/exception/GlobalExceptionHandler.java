package com.api.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView globalError(Exception exception) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error.html");
        return mav;
    }
}
