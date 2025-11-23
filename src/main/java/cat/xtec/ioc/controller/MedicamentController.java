package cat.xtec.ioc.controller;

import cat.xtec.ioc.service.MedicamentService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/medicaments")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @RequestMapping("/all")
    public ModelAndView allMedicaments(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("medicaments");
        modelview.getModelMap().addAttribute("medicaments", medicamentService.getAllMedicaments());
        return modelview;
    }

    @RequestMapping("/{category}")
    public ModelAndView getMedicamentsByCategory(@PathVariable("category") String medicamentCategory, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("medicaments");
        modelview.getModelMap().addAttribute("medicaments", medicamentService.getMedicamentsByCategory(medicamentCategory));
        return modelview;
    }

    @RequestMapping("/filter/{ByCriteria}")
    public ModelAndView getMedicamentsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelview = new ModelAndView("medicaments");
        modelview.getModelMap().addAttribute("medicaments", medicamentService.getMedicamentsByFilter(filterParams));
        return modelview;
    }
}
