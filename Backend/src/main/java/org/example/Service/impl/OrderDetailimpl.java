package org.example.Service.impl;

import io.swagger.v3.oas.annotations.Operation;
import org.example.Dto.OrderDetailDto;
import org.example.Entity.OrderDetail;
import org.example.Entity.Product;
import org.example.Repositroy.OrderDetailRepository;
import org.example.Repositroy.ProductRepositroy;
import org.example.Service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderDetailimpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository detailRepository;
    @Autowired
    private ProductRepositroy productRepositroy;

    @Override
    @Transactional
    public OrderDetail createDetail (OrderDetailDto detailDto){
        OrderDetail entity = new OrderDetail();
        entity.setOrderItemSN(detailDto.getOrderItemSN());
        entity.setOrder(detailDto.getOrderID());
        entity.setProductID(detailDto.getProductID());
        entity.setQuantity(detailDto.getQuantity());
        entity.setStandPrice(detailDto.getStandPrice());
        entity.setItemPrice(detailDto.getItemPrice());
//        Product product = new Product();
//        product.setProductId(detailDto.getProductID());
//        product.setQuantity(product.getQuantity() - detailDto.getQuantity());
        Optional<Product> result = productRepositroy.findById(detailDto.getProductID());
        Product product = result.get();
        product.setQuantity(product.getQuantity() - detailDto.getQuantity());
        productRepositroy.save(product);
        return detailRepository.save(entity);
    }
}
