package kz.moderntech.repository;

import kz.moderntech.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByPriceIsGreaterThan(double price);

    Product findProductByName(String name);

    List<Product> findProductsByPriceBetween(double minPrice, double maxPrice);
}
