package drinkup.spring.services.product;


import drinkup.spring.domain.Product;

public interface ProductService {
    Iterable<Product> listAllProducts();

    Product getProductById(int id);

    Product saveProduct(Product product);

    void deleteProduct(int id);
}
