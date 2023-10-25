package org.example.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "ClientOrder")
public class Order {
    @Id
    @Column(name = "Order_ID")
    private String OrderID;

    @Column(name = "Member_ID")
    private String MemberID;

    @Column(name = "Price")
    private int Price;

    @Column(name = "Pay_Status")
    private Boolean PayStatus;

    @Transient
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderDetail> orderDetail;
}
