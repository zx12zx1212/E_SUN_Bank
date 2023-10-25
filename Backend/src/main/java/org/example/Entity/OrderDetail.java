package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @Column(name = "Order_ItemSN")
    private String OrderItemSN;

    @Column(name = "Product_ID")
    private String ProductID;

    @Column(name = "Quantity")
    private int Quantity;

    @Column(name = "Stand_Price")
    private int StandPrice;

    @Column(name = "Item_Price")
    private int ItemPrice;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "Order_ID")
    private Order order;
}
