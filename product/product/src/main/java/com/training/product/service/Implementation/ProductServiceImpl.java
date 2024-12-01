package com.training.product.service.Implementation;

import com.training.product.model.Product;
import com.training.product.repository.ProductRepository;
import com.training.product.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product createProduct(Product product) {
        // You might want to add validation logic here
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setCategory(updatedProduct.getCategory()); // Update category if needed
                    return productRepository.save(existingProduct);
                })
                .orElse(null); // Or throw an exception if not found
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
