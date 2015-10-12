package drinkup.spring.services.drinkorder;

import drinkup.spring.domain.DrinkOrder;
import drinkup.spring.repositories.DrinkOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkOrderServiceImpl implements DrinkOrderService {
    private DrinkOrderRepository drinkOrderRepository;

    @Autowired
    public void setDrinkOrderRepository(DrinkOrderRepository drinkOrderRepository) {
        this.drinkOrderRepository = drinkOrderRepository;
    }

    @Override
    public Iterable<DrinkOrder> listAllDrinkOrders() {
        return drinkOrderRepository.findAll();
    }

    @Override
    public DrinkOrder getDrinkOrderById(int id) {
        return drinkOrderRepository.findOne(id);
    }

    @Override
    public DrinkOrder saveDrinkOrder(DrinkOrder drinkOrder) {
        return drinkOrderRepository.save(drinkOrder);
    }

    @Override
    public void deleteDrinkOrder(int id) {
        drinkOrderRepository.delete(id);
    }
}
