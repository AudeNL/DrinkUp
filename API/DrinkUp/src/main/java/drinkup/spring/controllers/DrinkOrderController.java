package drinkup.spring.controllers;

import drinkup.spring.domain.DrinkOrder;
import drinkup.spring.services.drinkorder.DrinkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DrinkOrderController {

    private DrinkOrderService drinkOrderService;

    @Autowired
    public void setDrinkOrderService(DrinkOrderService drinkOrderService) {
        this.drinkOrderService = drinkOrderService;
    }

    @RequestMapping(value = "/drinkOrders", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("drinkOrders", drinkOrderService.listAllDrinkOrders());
        return "drinkOrders";
    }

    @RequestMapping("drinkOrder/{id}")
    public String showDrinkOrder(@PathVariable int id, Model model){
        model.addAttribute("drinkOrder", drinkOrderService.getDrinkOrderById(id));
        return "drinkOrdershow";
    }

    @RequestMapping("drinkOrder/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("drinkOrder", drinkOrderService.getDrinkOrderById(id));
        return "drinkOrderform";
    }

    @RequestMapping("drinkOrder/new")
    public String newDrinkOrder(Model model){
        model.addAttribute("drinkOrder", new DrinkOrder());
        return "drinkOrderform";
    }

    @RequestMapping(value = "drinkOrder", method = RequestMethod.POST)
    public String saveDrinkOrder(DrinkOrder drinkOrder){
        drinkOrderService.saveDrinkOrder(drinkOrder);
        return "redirect:/drinkOrder/" + drinkOrder.getIdOrder();
    }

    @RequestMapping("drinkOrder/delete/{id}")
    public String delete(@PathVariable int id){
        drinkOrderService.deleteDrinkOrder(id);
        return "redirect:/drinkOrders";
    }

}
