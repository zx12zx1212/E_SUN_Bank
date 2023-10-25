package org.example.Service.impl;

import org.example.Dto.OrderDto;
import org.example.Entity.Order;
import org.example.Repositroy.OrderRepository;
import org.example.Service.OrderService;
import org.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Orderimpl implements OrderService {

    @Autowired
    private OrderRepository orderRepositroy;
    @Autowired
    private ProductService productService;

    @Override
    @Transactional
    public Order createOrder(OrderDto orderDto){
        Order entity = new Order();
        entity.setOrderID(orderDto.getOrderID());
        entity.setMemberID(orderDto.getMemberID());
        entity.setPrice(orderDto.getPrice());
        entity.setPayStatus(orderDto.getPayStatus());
        return orderRepositroy.save(entity);
    }
}
