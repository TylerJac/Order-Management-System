package org.order_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Find product by ID
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    // Save a new product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    // Delete a product by ID
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

