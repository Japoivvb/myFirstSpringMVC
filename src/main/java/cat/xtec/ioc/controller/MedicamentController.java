package cat.xtec.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import cat.xtec.ioc.domain.repository.MedicamentRepository;
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

    @Autowired
    private MedicamentRepository medicamentRepository;

    @RequestMapping(value = "/medicaments", method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // to define view to return using a logic model
        ModelAndView modelview = new ModelAndView("medicaments");
        // add domain object medicament        
        modelview.getModelMap().addAttribute("medicaments", medicamentRepository.getAllMedicaments());
        return modelview;
    }
}
