package drinkup.spring.controllers;

import drinkup.spring.domain.Customer;
import drinkup.spring.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping("customer/{id}")
    public String showCustomer(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customershow";
    }

    @RequestMapping("customer/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customerform";
    }

    @RequestMapping("customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerform";
    }

    @RequestMapping(value = "customer", method = RequestMethod.POST)
    public String saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer/" + customer.getIdCustomer();
    }

    @RequestMapping("customer/delete/{id}")
    public String delete(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

}
