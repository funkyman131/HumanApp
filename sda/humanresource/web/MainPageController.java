package pl.sda.humanresource.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class MainPageController {

    @GetMapping("/")
    public ModelAndView displayMainPage(){
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("currentDate", LocalDate.now());
        return mav;
    }
}
