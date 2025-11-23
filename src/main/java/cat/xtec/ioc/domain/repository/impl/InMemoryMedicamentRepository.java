package cat.xtec.ioc.domain.repository.impl;

import cat.xtec.ioc.domain.Medicament;
import cat.xtec.ioc.domain.repository.MedicamentRepository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryMedicamentRepository implements MedicamentRepository {

    private List<Medicament> listOfMedicaments = new ArrayList<Medicament>();

    public InMemoryMedicamentRepository() {
        Medicament ibuprofe = new Medicament("M010", "Ibuprofé", 2);
        ibuprofe.setDescription("Ibuprofé de 600mg");
        ibuprofe.setCategory("Anti-inflamatori");
        ibuprofe.setProducer("Cinfa");
        ibuprofe.setStockQuantity(214);

        Medicament paracetamol = new Medicament("M020", "Paracetamol", 2.6);
        paracetamol.setDescription("Paracetamol 1g");
        paracetamol.setCategory("Analgèsic");
        paracetamol.setProducer("Ferrer");
        paracetamol.setStockQuantity(56);

        Medicament acacetilsalicilico = new Medicament("M030", "Ac Acetil Salicílico", 2.6);
        acacetilsalicilico.setDescription("Ac Acetil Salicílico");
        acacetilsalicilico.setCategory("Analgèsic");
        acacetilsalicilico.setProducer("Bayer");
        acacetilsalicilico.setStockQuantity(15);

        listOfMedicaments.add(ibuprofe);
        listOfMedicaments.add(paracetamol);
        listOfMedicaments.add(acacetilsalicilico);
    }

    public List<Medicament> getAllMedicaments() {
        return listOfMedicaments;
    }

    public Medicament getMedicamentById(String medicamentId) {
        Medicament medicamentById = null;
        for (Medicament medicament : listOfMedicaments) {
            if (medicament != null && medicament.getMedicamentId() != null
                    && medicament.getMedicamentId().equals(medicamentId)) {
                medicamentById = medicament;
                break;
            }
        }
        if (medicamentById == null) {
            throw new IllegalArgumentException(
                    "No s'han trobat medicaments amb el codi: " + medicamentId);
        }
        return medicamentById;
    }

    public List<Medicament> getMedicamentsByCategory(String category) {
        List<Medicament> medicamentsByCategory = new ArrayList<Medicament>();
        for (Medicament medicament : listOfMedicaments) {
            if (category.equalsIgnoreCase(medicament.getCategory())) {
                medicamentsByCategory.add(medicament);
            }
        }
        return medicamentsByCategory;
    }

    public Set<Medicament> getMedicamentsByFilter(Map<String, List<String>> filterParams) {
        Set<Medicament> medicamentsByProducer = new HashSet<Medicament>();
        Set<Medicament> medicamentsInStockRange = new HashSet<Medicament>();
        Set<String> criterias = filterParams.keySet();
        long minStock = 0;
        long maxStock = 0;
        if (criterias.contains("producer")) {
            for (String producerName : filterParams.get("producer")) {
                for (Medicament medicament : listOfMedicaments) {
                    if (producerName.equalsIgnoreCase(medicament.getProducer())) {
                        medicamentsByProducer.add(medicament);
                    }
                }
            }
        }
        if (criterias.contains("estoc")) {
            minStock = Long.parseLong(filterParams.get("estoc").get(0));
            maxStock = Long.parseLong(filterParams.get("estoc").get(1));

            for (Medicament medicament : listOfMedicaments) {
                if ((medicament.getStockQuantity() >= minStock) && (medicament.getStockQuantity() <= maxStock)) {
                    medicamentsInStockRange.add(medicament);
                }
            }

        }
        medicamentsInStockRange.retainAll(medicamentsByProducer);
        return medicamentsInStockRange;
    }
}
