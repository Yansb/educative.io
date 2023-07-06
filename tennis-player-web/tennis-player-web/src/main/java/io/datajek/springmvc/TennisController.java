package io.datajek.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TennisController {

    @RequestMapping("/")
    public String welcome() {
        return "main-menu";
    }
}
