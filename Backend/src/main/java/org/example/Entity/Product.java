package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Product")
public class Product {
    @Id
    @Column(name = "Product_ID")
    private String ProductId;

    @Column(name = "Product_Name")
    private String ProductName;

    @Column(name = "Price")
    private int Price;

    @Column(name = "Quantity")
    private int Quantity;

}
