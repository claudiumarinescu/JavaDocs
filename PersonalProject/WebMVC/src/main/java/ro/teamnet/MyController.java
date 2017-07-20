package ro.teamnet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Claudiu.Marinescu on 7/20/2017.
 */
@Controller
public class MyController {

    @RequestMapping(value = "/")
    public String home() {
        return "test";
    }

}
