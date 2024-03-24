package by.study.news.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
	
    @ExceptionHandler(value = {Exception.class})
    public String handleError(HttpServletRequest request, Exception e) {

    	System.out.println("entered exception controller");

        return "pages/error";
       
        
    }
}