package com.todeb.bkolay.usedvehiclesaleapplication.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String title;
    private String details;
    private double price;
    private int day;
    //Sonradan eklenilenler
    //private int viewed;
    //private int favorite;
}
