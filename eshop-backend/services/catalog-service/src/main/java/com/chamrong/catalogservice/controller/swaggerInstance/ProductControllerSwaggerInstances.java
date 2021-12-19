package com.chamrong.catalogservice.controller.swaggerInstance;

public class ProductControllerSwaggerInstances {
  private ProductControllerSwaggerInstances() {
    // nothing to here
  }

  // create product
  public static final String CREATE_PRODUCT_SUMMARY = "To create a new product";
  public static final String CREATE_PRODUCT_DESCRIPTION =
      "To create a new product. This request will return an object of product.";
  public static final String CREATE_PRODUCT_RESPONSE_201 = "Create a new product success response.";

  // get a product by id
  public static final String GET_PRODUCT_BY_ID_SUMMARY = "To retrieve an object of product";
  public static final String GET_PRODUCT_BY_ID_DESCRIPTION =
      "To retrieve an object of product. This request will return an object of product.";
  public static final String GET_PRODUCT_BY_ID_RESPONSE_200 =
      "Retrieve an object of product success response.";

  // fetch all products
  public static final String FETCH_ALL_PRODUCT_SUMMARY = "To fetch all product";
  public static final String FETCH_ALL_PRODUCT_DESCRIPTION =
      "To fetch all product. This request will return a list of products.";
  public static final String FETCH_ALL_PRODUCT_RESPONSE_200 =
      "Fetch a list of product success response.";

  // update an existing product by id
  public static final String UPDATE_AN_EXISTING_PRODUCT_BY_ID_SUMMARY =
      "To update an existing product by id";
  public static final String UPDATE_AN_EXISTING_PRODUCT_BY_ID_DESCRIPTION =
      "To update an existing product by id. This request will return an updated product.";
  public static final String UPDATE_AN_EXISTING_PRODUCT_BY_ID_RESPONSE_200 =
      "Update an existing product by id success response.";

  // delete an existing product by id
  public static final String DELETE_AN_EXISTING_PRODUCT_BY_ID_SUMMARY =
      "To delete an existing product by id";
  public static final String DELETE_AN_EXISTING_PRODUCT_BY_ID_DESCRIPTION =
      "To delete an existing product by id. This request will return a message of deleted succeed";
  public static final String DELETE_AN_EXISTING_PRODUCT_BY_ID_204 =
      "Delete an existing product by id success response.";
}
