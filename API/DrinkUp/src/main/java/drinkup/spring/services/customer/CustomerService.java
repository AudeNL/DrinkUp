package drinkup.spring.services.customer;


import drinkup.spring.domain.Customer;

public interface CustomerService {
    Iterable<Customer> listAllCustomers();

    Customer getCustomerById(int id);

    Customer saveCustomer(Customer customer);

    void deleteCustomer(int id);
}
