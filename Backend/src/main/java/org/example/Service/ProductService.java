package org.example.Service;

import org.example.Dto.ProductDto;
import org.example.Entity.Product;

import java.util.List;

public interface ProductService {
    Product create(ProductDto productDto);
    Product serarchID(String id);
    List<Product> list();
}
