package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Medicament;
import cat.xtec.ioc.domain.repository.MedicamentRepository;
import cat.xtec.ioc.service.MedicamentService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    public List<Medicament> getAllMedicaments() {
        return medicamentRepository.getAllMedicaments();
    }

    public Medicament getMedicamentById(String medicamentID) {
        return medicamentRepository.getMedicamentById(medicamentID);
    }
    
    public List<Medicament> getMedicamentsByCategory(String category) {
        return medicamentRepository.getMedicamentsByCategory(category);
    }
    
    public Set<Medicament> getMedicamentsByFilter(Map<String, List<String>> filterParams) {
        return medicamentRepository.getMedicamentsByFilter(filterParams);
    }
}