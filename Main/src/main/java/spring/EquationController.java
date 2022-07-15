package spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EquationController {

    @RequestMapping("/")
    public String greeting(Model model) {
        model.addAttribute("type","квадратных");
        return "equation";
    }

}
