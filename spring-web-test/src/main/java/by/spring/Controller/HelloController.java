package by.spring.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setViewName("hello");
        modelAndView.addObject("message", "hello world");
        return modelAndView;
    }


    @GetMapping("/test")
    public String test(String name, Model model) {
        model.addAttribute("Name", name);
        if (name.equals("nikita")) {
            throw new RuntimeException();
        }
        return "test";
    }

    @GetMapping("/{number}")
    public String test2(@PathVariable int number, Model model) {

        model.addAttribute("myNumber", number);
        return "number";
    }

//    @ExceptionHandler(RuntimeException.class)
//    public String exceptionHandler(RuntimeException e) {
//
//        return "error";
//    }

}
