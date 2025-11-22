package cat.xtec.ioc.controller;

import cat.xtec.ioc.domain.Medicament;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicamentController {

    @RequestMapping(value = "/medicaments", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // to define view to return using a logic model
        ModelAndView modelview = new ModelAndView("medicaments");
        Medicament ibuprofe = new Medicament("M010", "Ibuprofé", 2);
        ibuprofe.setDescription("Ibuprofé de 600mg");
        ibuprofe.setCategory("Anti-inflamatori");
        ibuprofe.setProducer("Cinfa");
        ibuprofe.setStockQuantity(214);
        // add domain object medicament
        modelview.getModelMap().addAttribute("medicament", ibuprofe);
        return modelview;
    }
}