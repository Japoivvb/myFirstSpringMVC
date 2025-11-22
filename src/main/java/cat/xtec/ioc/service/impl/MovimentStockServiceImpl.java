package cat.xtec.ioc.service.impl;

import cat.xtec.ioc.domain.Medicament;
import cat.xtec.ioc.domain.repository.MedicamentRepository;
import cat.xtec.ioc.service.MovimentStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentStockServiceImpl implements MovimentStockService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    public void processMovimentStock(String medicamentId, long quantity, int signe) {
        // check medicament exists calling persist layer
        Medicament medicamentById = medicamentRepository.getMedicamentById(medicamentId);
        long signedQuantity = quantity * signe;
        
        // check there is stock
        if ((medicamentById.getStockQuantity() + signedQuantity) < 0) {
            throw new IllegalArgumentException("No hi ha prou unitats. La quantitat en estoc és: " + medicamentById.getStockQuantity());
        }
        
        // update stock
        medicamentById.setStockQuantity(medicamentById.getStockQuantity() + signedQuantity);
    }
}
