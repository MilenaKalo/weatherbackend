package htw.berlin.weatherbackend.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public ModelAndView showStartseite(){
        return new ModelAndView("Startseite");
    }
}
