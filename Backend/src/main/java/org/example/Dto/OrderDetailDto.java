package org.example.Dto;

import lombok.Getter;
import lombok.Setter;
import org.example.Entity.Order;

import javax.persistence.Column;

@Getter
@Setter
public class OrderDetailDto {
    @Column(name = "Order_ItemSN")
    private String OrderItemSN;

    @Column(name = "Order_ID")
    private Order OrderID;

    @Column(name = "Product_ID")
    private String ProductID;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Stand_Price")
    private int StandPrice;

    @Column(name = "ItemPrice")
    private int ItemPrice;
}
