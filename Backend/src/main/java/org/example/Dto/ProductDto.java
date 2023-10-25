package org.example.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class ProductDto {

    @Column(name = "Product_ID")
    private String ProductId;

    @Column(name = "Product_Name")
    private String ProductName;

    @Column(name = "Price")
    private int Price;

    @Column(name = "Quantity")
    private int Quantity;

}
