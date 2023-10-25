package org.example.Service.impl;

import org.example.Dto.ProductDto;
import org.example.Entity.Product;
import org.example.Repositroy.ProductRepositroy;
import org.example.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Productimpl implements ProductService {
    @Autowired
    private ProductRepositroy productRepositroy;

    @Override
    @Transactional
    public Product create(ProductDto productDto){
        Product entity = new Product();
        entity.setProductId(productDto.getProductId());
        entity.setProductName(productDto.getProductName());
        entity.setPrice(productDto.getPrice());
        entity.setQuantity(productDto.getQuantity());
        return productRepositroy.save(entity);
    }

    @Override
    public List<Product> list(){
        List<Product> search_result = productRepositroy.findAll();
        List<Product> result = new ArrayList<>();
        for(Product p :search_result){
            if(p.getQuantity() > 0 ){
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Product serarchID(String id){
        Optional<Product> result = productRepositroy.findById(id);
        return result.get();
    }
}
