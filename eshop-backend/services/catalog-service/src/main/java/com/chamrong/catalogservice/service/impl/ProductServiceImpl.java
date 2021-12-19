package com.chamrong.catalogservice.service.impl;

import com.chamrong.catalogservice.entity.Product;
import com.chamrong.catalogservice.exception.ResourceNotFoundException;
import com.chamrong.catalogservice.payload.ProductDto;
import com.chamrong.catalogservice.repository.ProductRepository;
import com.chamrong.catalogservice.service.ProductService;
import com.chamrong.catalogservice.utils.Message;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/** Created by Chamrong on 12 Dec, 2021 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  private final ModelMapper modelMapper;

  ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
  }

  /**
   * To save a new product of {@link Product}
   *
   * @param productDto refers to an instance of {@link ProductDto}
   * @return a created {@link ProductDto}
   */
  @Override
  public ProductDto saveProduct(ProductDto productDto) {
    log.info(Message.logMethodInfoProccessing("saveProduct", "ProductServiceImpl"));
    return mapToDto(productRepository.save(mapToEntity(productDto)));
  }

  /**
   * To get an object of {@link Product}
   *
   * @param id refer to identified of {@link Product}
   * @return an object of {@link ProductDto}
   */
  @Override
  public ProductDto findProductById(Long id) {
    log.info(Message.logMethodInfoProccessing("findProductById", "ProductServiceImpl"));
    return mapToDto(
        productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ProductDto", "id", id.toString())));
  }

  /**
   * To fetch all objects of {@link Product}
   *
   * @return a list of {@link ProductDto}
   */
  @Override
  public List<ProductDto> fetchAllProduct() {
    log.info(Message.logMethodInfoProccessing("fetchAllProduct", "ProductServiceImpl"));
    List<Product> products = productRepository.findAll();

    return products.stream().map(this::mapToDto).collect(Collectors.toList());
  }

  /**
   * To update an existing product by id of {@link Product}
   *
   * @param id refer to identified of {@link Product}
   * @param productDto refers to an instance of {@link ProductDto}
   * @return an updated of {@link ProductDto}
   */
  @Override
  public ProductDto updateProductById(Long id, ProductDto productDto) {
    log.info(Message.logMethodInfoProccessing("updateProductById", "ProductServiceImpl"));
    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ProductDto", "id", id.toString()));
    product.setName(productDto.getName());
    product.setBarcode(productDto.getBarcode());
    product.setDescription(productDto.getDescription());
    product.setMetaTagTitle(productDto.getMetaTagTitle());
    product.setMetaTagDescription(productDto.getMetaTagDescription());
    product.setMetaTagKeyword(productDto.getMetaTagKeyword());
    product.setTag(productDto.getTag());
    return mapToDto(productRepository.save(product));
  }

  @Override
  public String deleteProductById(Long id) {
    log.info(Message.logMethodInfoProccessing("deleteProductById", "ProductServiceImpl"));
    Product product =
        productRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("ProductDto", "id", id.toString()));
    productRepository.delete(product);
    return Message.deleteSuccess("ProductDto", "id", id.toString());
  }

  /**
   * To convert from {@link Product} to {@link ProductDto}
   *
   * @param product refers to an object of {@link Product}
   * @return an object of {@link ProductDto}
   */
  private ProductDto mapToDto(Product product) {

    // If no model mapper -->
    //    ProductDto productDto = new ProductDto();
    //    productDto.setName(product.getName());
    //    productDto.setBarcode(product.getBarcode());
    //    productDto.setDescription(product.getDescription());
    //    productDto.setMetaTagTitle(product.getMetaTagTitle());
    //    productDto.setMetaTagDescription(product.getMetaTagDescription());
    //    productDto.setMetaTagKeyword(product.getMetaTagKeyword());
    //    productDto.setTag(product.getTag());
    //
    //    return productDto;

    return modelMapper.map(product, ProductDto.class);
  }

  /**
   * To convert from {@link ProductDto} to {@link Product}
   *
   * @param productDto to an instance of {@link ProductDto}
   * @return an object of {@link Product}
   */
  private Product mapToEntity(ProductDto productDto) {

    // If no ModelMapper -->
    //    Product product = new Product();
    //    product.setName(productDto.getName());
    //    product.setBarcode(productDto.getBarcode());
    //    product.setDescription(productDto.getDescription());
    //    product.setMetaTagTitle(productDto.getMetaTagTitle());
    //    product.setMetaTagDescription(productDto.getMetaTagDescription());
    //    product.setMetaTagKeyword(productDto.getMetaTagKeyword());
    //    product.setTag(productDto.getTag());
    //
    //    return product;

    return modelMapper.map(productDto, Product.class);
  }
}
