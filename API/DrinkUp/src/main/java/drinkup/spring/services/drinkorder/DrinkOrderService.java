package drinkup.spring.services.drinkorder;


import drinkup.spring.domain.DrinkOrder;

public interface DrinkOrderService {
    Iterable<DrinkOrder> listAllDrinkOrders();

    DrinkOrder getDrinkOrderById(int id);

    DrinkOrder saveDrinkOrder(DrinkOrder drinkOrder);

    void deleteDrinkOrder(int id);
}
