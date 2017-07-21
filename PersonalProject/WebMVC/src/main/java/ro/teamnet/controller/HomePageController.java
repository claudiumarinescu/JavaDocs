package ro.teamnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Claudiu.Marinescu on 7/20/2017.
 */
@Controller
public class HomePageController {

    @RequestMapping(value = "/")
    public String home() {
        return "/WEB-INF/views/index.jsp";
    }

}
