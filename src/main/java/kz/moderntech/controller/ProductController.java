package kz.moderntech.controller;

import kz.moderntech.model.Product;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        products.add(product);
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return products;
    }

    @GetMapping("/greaterThan/{price}")
    public List<Product> greaterThan(@PathVariable double price) {
        var productList = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getPrice() > price) {
                productList.add(product);
            }
        }
        return productList;
    }

    @GetMapping("/filter")
    public List<Product> filter(@RequestParam String name, @RequestParam double minPrice, @RequestParam double maxPrice) {
        var productList = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getName().equals(name)) {
                if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                    productList.add(product);
                }
            }
        }
        return productList;
    }

    private final List<Product> products = new ArrayList<>();

}
