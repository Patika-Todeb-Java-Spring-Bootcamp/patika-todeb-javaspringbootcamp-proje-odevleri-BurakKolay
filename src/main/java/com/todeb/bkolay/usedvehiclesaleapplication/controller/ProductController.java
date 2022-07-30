package com.todeb.bkolay.usedvehiclesaleapplication.controller;

import com.todeb.bkolay.usedvehiclesaleapplication.model.dto.ProductDTO;
import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Product;
import com.todeb.bkolay.usedvehiclesaleapplication.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity getAllProduct(){
        List<Product> allProduct = productService.getAllProduct();
        return ResponseEntity.ok(allProduct);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable("id") Long id){
        Product byId= productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(byId);
    }
    @PostMapping("/create")
    public ResponseEntity createNewProduct(@RequestBody ProductDTO product){
        Product respProduct = productService.create(product);
        if(respProduct==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Product could not be created successfully");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(respProduct);
    }
    @DeleteMapping
    public ResponseEntity deleteProduct(@RequestParam(name = "id") Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Related Product deleted successfully");
    }

    @PutMapping("/{title}")
    public ResponseEntity updateProduct(
            @PathVariable String title,
            @RequestBody ProductDTO product)
    {
        Product update = productService.update(title, product);
        if(update == null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Product could not be updated successfully");
        }
        return ResponseEntity.status(HttpStatus.OK).body(update);
    }
}
