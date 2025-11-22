package cat.xtec.ioc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/holamon")
public class HolaMonController {
    @RequestMapping(method = RequestMethod.GET)
    public String hola(ModelMap model) {
        model.addAttribute("salutacio", "Hola Mon Spring amb Java configuration");
        return "benvinguda";
    }
 
    @RequestMapping(value = "/holadenou", method = RequestMethod.GET)
    public String holaDeNou(ModelMap model) {
        model.addAttribute("salutacio", "Hola Mon de nou Spring amb Java configuration");
        return "benvinguda";
    }
}
