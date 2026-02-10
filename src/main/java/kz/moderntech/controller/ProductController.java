package kz.moderntech.controller;

import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.Product;
import kz.moderntech.repository.ProductRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController extends BaseController<Product, Long> {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        super(productRepository);
        this.productRepository = productRepository;
    }

    @GetMapping("/find-price-greater-than")
    public List<Product> findProductsByPriceGreaterThan(@RequestParam double price) {
        return productRepository.findProductsByPriceIsGreaterThan(price);
    }

    @GetMapping("/{name}")
    public Product findProductsByName(@PathVariable String name) {
        return productRepository.findProductByName(name);
    }

    @GetMapping("/filter-by-price")
    public List<Product> filterByPrice(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return productRepository.findProductsByPriceBetween(minPrice, maxPrice);
    }

}
