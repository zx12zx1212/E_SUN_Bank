package org.example.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class OrderDto {
    @Column(name = "Order_ID")
    private String OrderID;

    @Column(name = "Member_ID")
    private String MemberID;

    @Column(name = "Price")
    private int Price;

    @Column(name = "Pay_Status")
    private Boolean PayStatus;
}
