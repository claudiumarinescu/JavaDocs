package ro.teamnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Claudiu.Marinescu on 7/21/2017.
 */
@Controller
public class WelcomePageController {

    @RequestMapping("/")
    public ModelAndView welcome() {

        ModelAndView model = new ModelAndView("index");
        model.addObject("welcomeMessage", "Howdy, visitor! Enjoy my app!");

        return model;
    }

}
