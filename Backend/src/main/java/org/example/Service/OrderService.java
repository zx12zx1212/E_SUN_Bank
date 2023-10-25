package org.example.Service;

import org.example.Dto.OrderDto;
import org.example.Entity.Order;

public interface OrderService {
    Order createOrder (OrderDto orderDto);
}
