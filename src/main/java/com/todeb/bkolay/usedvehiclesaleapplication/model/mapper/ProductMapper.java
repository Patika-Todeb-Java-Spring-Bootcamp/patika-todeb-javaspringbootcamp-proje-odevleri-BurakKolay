package com.todeb.bkolay.usedvehiclesaleapplication.model.mapper;

import com.todeb.bkolay.usedvehiclesaleapplication.model.dto.ProductDTO;
import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Product;

public class ProductMapper {
    public static ProductDTO toDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setTitle(product.getTitle());
        productDTO.setDetails(product.getDetails());
        productDTO.setPrice(product.getPrice());
        productDTO.setDay(product.getDay());
        return productDTO;
    }

    public static Product toEntity(ProductDTO productDTO){
        Product product = new Product();
        product.setTitle(productDTO.getTitle());
        product.setDetails(productDTO.getDetails());
        product.setPrice(productDTO.getPrice());
        product.setDay(productDTO.getDay());
        return product;
    }
}
