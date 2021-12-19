package com.chamrong.catalogservice.controller;

import com.chamrong.catalogservice.controller.swaggerInstance.ProductControllerSwaggerInstances;
import com.chamrong.catalogservice.entity.Product;
import com.chamrong.catalogservice.exception.ProductNotFoundException;
import com.chamrong.catalogservice.payload.ProductDto;
import com.chamrong.catalogservice.service.ProductService;
import com.chamrong.catalogservice.service.impl.ProductServiceImpl;
import com.chamrong.catalogservice.utils.Message;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/** Created by Chamrong on 12 Dec, 2021 */
@RestController
@Slf4j
@RequestMapping("/api/v1/products")
@Tag(name = "Product", description = "Endpoints for managing product")
public class ProductController {

  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * To create a new product of {@link Product}
   *
   * @see ProductServiceImpl#saveProduct(ProductDto productDto)
   * @param productDto refer to an instance of {@link ProductDto}
   * @return a created product of {@link ProductDto}
   */
  @Operation(
      operationId = "createProduct",
      summary = ProductControllerSwaggerInstances.CREATE_PRODUCT_SUMMARY,
      description = ProductControllerSwaggerInstances.CREATE_PRODUCT_DESCRIPTION,
      responses = {
        @ApiResponse(
            description = ProductControllerSwaggerInstances.CREATE_PRODUCT_RESPONSE_201,
            responseCode = "201",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)))
      })
  @PostMapping
  public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto) {
    log.info(Message.logMethodInfoProccessing("createProduct", "ProductController"));
    return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
  }

  /**
   * To retrieve all product of {@link ProductDto}
   *
   * @see ProductServiceImpl#fetchAllProduct()
   * @return a list of {@link ProductDto}
   */
  @Operation(
      operationId = "fetchAllProduct",
      summary = ProductControllerSwaggerInstances.FETCH_ALL_PRODUCT_SUMMARY,
      description = ProductControllerSwaggerInstances.FETCH_ALL_PRODUCT_DESCRIPTION,
      responses = {
        @ApiResponse(
            description = ProductControllerSwaggerInstances.FETCH_ALL_PRODUCT_RESPONSE_200,
            responseCode = "200",
            content = @Content(mediaType = "application/json"))
      })
  @GetMapping
  public ResponseEntity<List<ProductDto>> fetchAllProduct() {
    log.info(Message.logMethodInfoProccessing("fetchAllProduct", "ProductController"));

    return new ResponseEntity<>(productService.fetchAllProduct(), HttpStatus.OK);
  }

  /**
   * To retrieve an object of {@link ProductDto}
   *
   * @see ProductServiceImpl#findProductById(Long id)
   * @param id refers to identified of {@link ProductDto}
   * @return an object of {@link ProductDto}
   */
  @Operation(
      operationId = "getProductById",
      summary = ProductControllerSwaggerInstances.GET_PRODUCT_BY_ID_SUMMARY,
      description = ProductControllerSwaggerInstances.GET_PRODUCT_BY_ID_DESCRIPTION,
      responses = {
        @ApiResponse(
            description = ProductControllerSwaggerInstances.GET_PRODUCT_BY_ID_RESPONSE_200,
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)))
      })
  @Parameters(@Parameter(name = "id", example = "1"))
  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id)
      throws ProductNotFoundException {
    log.info(Message.logMethodInfoProccessing("getProductById", "ProductController"));

    return new ResponseEntity<>(productService.findProductById(id), HttpStatus.OK);
  }

  /**
   * To update an existing object of {@link ProductDto}
   *
   * @see ProductServiceImpl#updateProductById(Long id, ProductDto productDto)
   * @param id refers to identified of {@link ProductDto}
   * @param productDto refer to an instance of {@link ProductDto}
   * @return an updated object of {@link ProductDto}
   */
  @Operation(
      operationId = "updateProductById",
      summary = ProductControllerSwaggerInstances.UPDATE_AN_EXISTING_PRODUCT_BY_ID_SUMMARY,
      description = ProductControllerSwaggerInstances.UPDATE_AN_EXISTING_PRODUCT_BY_ID_DESCRIPTION,
      responses = {
        @ApiResponse(
            description =
                ProductControllerSwaggerInstances.UPDATE_AN_EXISTING_PRODUCT_BY_ID_RESPONSE_200,
            responseCode = "200",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ProductDto.class)))
      })
  @Parameters(@Parameter(name = "id", example = "1"))
  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateProductById(
      @PathVariable("id") Long id, @RequestBody ProductDto productDto) {
    log.info(Message.logMethodInfoProccessing("updateProductById", "ProductController"));

    return ResponseEntity.ok(productService.updateProductById(id, productDto));
  }

  /**
   * To delete an object of {@link ProductDto}
   *
   * @param id refers to identified of {@link ProductDto}
   * @return a message of deleted succeed
   */
  @Operation(
      operationId = "deleteProductById",
      summary = ProductControllerSwaggerInstances.DELETE_AN_EXISTING_PRODUCT_BY_ID_SUMMARY,
      description = ProductControllerSwaggerInstances.DELETE_AN_EXISTING_PRODUCT_BY_ID_DESCRIPTION,
      responses = {
        @ApiResponse(
            description = ProductControllerSwaggerInstances.DELETE_AN_EXISTING_PRODUCT_BY_ID_204)
      })
  @Parameters(@Parameter(name = "id", example = "1"))
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteProductById(@PathVariable("id") Long id) {
    log.info(Message.logMethodInfoProccessing("deleteProductById", "ProductController"));
    return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
  }
}
