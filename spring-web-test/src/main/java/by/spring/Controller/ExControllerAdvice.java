package by.spring.Controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExControllerAdvice {

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(RuntimeException e) {
        return "error";
    }

}
