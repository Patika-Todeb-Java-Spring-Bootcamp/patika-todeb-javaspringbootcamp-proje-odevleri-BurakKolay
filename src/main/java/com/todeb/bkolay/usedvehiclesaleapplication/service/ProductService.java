package com.todeb.bkolay.usedvehiclesaleapplication.service;

import com.todeb.bkolay.usedvehiclesaleapplication.model.dto.ProductDTO;
import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Product;
import com.todeb.bkolay.usedvehiclesaleapplication.model.mapper.ProductMapper;
import com.todeb.bkolay.usedvehiclesaleapplication.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getAllProduct(){
        List<Product> allProduct = productRepository.findAll();
        return allProduct;
    }

    public Product getById(Long id){
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElseThrow(()-> new RuntimeException("Product not found"));
    }

    public Product create(ProductDTO productDTO){
        Product product = ProductMapper.toEntity(productDTO);
        return productRepository.save(product);
    }
    public void delete(Long id){
        getById(id);
        productRepository.deleteById(id);
    }

    public Product update(String title, ProductDTO product){
        Optional<Product> productByTitle = productRepository.findProductByTitle(title);
        if(!productByTitle.isPresent()){
            return null;
        }
        Product updatedProduct = productByTitle.get();
        if(!StringUtils.isEmpty(product.getTitle())){
            updatedProduct.setTitle(product.getTitle());
        }
        if(!StringUtils.isEmpty(product.getDetails())){
            updatedProduct.setDetails(product.getDetails());
        }
        return productRepository.save(updatedProduct);
    }
}
