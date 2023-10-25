package org.example.Controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.Dto.OrderDetailDto;
import org.example.Dto.OrderDto;
import org.example.Dto.ProductDto;
import org.example.Entity.Order;
import org.example.Entity.OrderDetail;
import org.example.Entity.Product;
import org.example.Service.OrderDetailService;
import org.example.Service.OrderService;
import org.example.Service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService detailService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("createProduct")
    @ApiOperation("新增產品")
    public ResponseEntity<ProductDto> createProduct (ProductDto productDto){
        Product entity = productService.create(productDto);
        ProductDto dto = modelMapper.map(entity, ProductDto.class);
        return ResponseEntity.ok().body(dto);
    }

//    @PostMapping("createOrder")
//    @ApiOperation("新增訂單")
//    public ResponseEntity<OrderDto> createOder (OrderDto orderDto){
//        Order entity = orderService.createOrder(orderDto);
//        OrderDto dto = modelMapper.map(entity, OrderDto.class);
//        return ResponseEntity.ok().body(dto);
//    }

    @PostMapping("createDetail")
    @ApiOperation("新增訂單細項")
    public ResponseEntity<OrderDetailDto> createOderDetail (OrderDetailDto detailDto){
        OrderDetail entity = detailService.createDetail(detailDto);
        OrderDetailDto dto = modelMapper.map(entity, OrderDetailDto.class);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("search")
    @ApiOperation("查詢所有商品")
    public ResponseEntity<List<ProductDto>> listProducts(){
        List<ProductDto> dto = new ArrayList();
        List<Product> entity = productService.list();
        for(Product e:entity){
            dto.add(modelMapper.map(e, ProductDto.class));
        }
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/search/{id}")
    @ApiOperation("查詢單一商品")
    public ResponseEntity<ProductDto> searchProducts(@PathVariable @ApiParam(value = "商品編號")String id){
        return ResponseEntity.ok().body(modelMapper.map(productService.serarchID(id) , ProductDto.class));
    }

}

