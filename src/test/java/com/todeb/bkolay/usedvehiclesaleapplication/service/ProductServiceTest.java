package com.todeb.bkolay.usedvehiclesaleapplication.service;

import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Person;
import com.todeb.bkolay.usedvehiclesaleapplication.model.entity.Product;
import com.todeb.bkolay.usedvehiclesaleapplication.repository.ProductRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {


    //Senaryo yazacağımız için mock'ladık. Kukla yerine kullandık.
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;



    @Test
    void getAllProduct() {
        // init step (Beklenilen sonucu)
        List<Product> expProductList = new ArrayList<>();
        Product product1 = new Product(1L,"Urun 1","Yeni urun eklendi",15.99,150,90,15,null);
        Product product2 = new Product(2L,"Urun 2","Yeni urun eklendi 2",25.99,150,70,10,null);
        Product product3 = new Product(3L,"Urun 3","Yeni urun eklendi 3",35.99,150,85,22,null);
        expProductList.add(product2);
        expProductList.add(product1);
        expProductList.add(product3);

        //stub - when step
        Mockito.when(productRepository.findAll()).thenReturn(expProductList);     //Eğerki ProductService içindeki findAll metodu çağırırsa
                                                                                  //Mockito bizim için expProductList'yi çağıracak.
        //then - validate step
        List<Product> actualProductList = productService.getAllProduct();

        Assert.assertEquals(expProductList.size(),actualProductList.size());

        System.out.println("First: "+expProductList);
        expProductList = expProductList.stream().sorted(getProductComparator()).collect(Collectors.toList());
        actualProductList = actualProductList.stream().sorted(getProductComparator()).collect(Collectors.toList());
        for (int i = 0; i < expProductList.size(); i++) {
            Product currExpProduct = expProductList.get(i);
            Product currActualProduct = actualProductList.get(i);
            Assert.assertEquals(currExpProduct.getId(),currActualProduct.getId());
            Assert.assertEquals(currExpProduct.getTitle(),currActualProduct.getTitle());
        }
        
        System.out.println("Second: "+expProductList);

    }

    private Comparator<Product> getProductComparator() {
        return (o1, o2) -> {
            if (o1.getId() - o2.getId() < 0)    // < yapılırsa artan ,> yapılırsa azalan sıralama olur.
                return -1;
            if (o1.getId() - o2.getId() == 0)
                return 0;
            return 1;
        };
    }

    @Test
    void getById() {
    }

    @Test
    void create() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}