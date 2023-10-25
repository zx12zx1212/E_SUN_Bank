package org.example.Service;

import org.example.Dto.OrderDetailDto;
import org.example.Entity.OrderDetail;

public interface OrderDetailService {
    OrderDetail createDetail (OrderDetailDto orderDetailDto);
}
