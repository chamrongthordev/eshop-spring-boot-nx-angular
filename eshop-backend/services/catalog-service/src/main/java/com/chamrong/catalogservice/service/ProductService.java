package com.chamrong.catalogservice.service;

import com.chamrong.catalogservice.exception.ProductNotFoundException;
import com.chamrong.catalogservice.payload.ProductDto;

import java.util.List;

public interface ProductService {
  ProductDto saveProduct(ProductDto productDto);

  ProductDto findProductById(Long id) throws ProductNotFoundException;

  List<ProductDto> fetchAllProduct();

  ProductDto updateProductById(Long id, ProductDto productDto);

  String deleteProductById(Long id);
}
