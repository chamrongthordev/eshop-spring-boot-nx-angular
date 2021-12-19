package com.chamrong.catalogservice.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ProductDto {
  @Schema(name = "id", type = "integer", format = "int64", example = "1")
  private Long id;

  @Schema(
      name = "name",
      description = "Product name",
      type = "string",
      minLength = 3,
      example = "Pepsi")
  private String name;

  @Schema(
      name = "barcode",
      description = "Product barcode",
      type = "string",
      minLength = 7,
      maxLength = 7,
      example = "PR-0001")
  private String barcode;

  @Schema(
      name = "description",
      description = "Product description",
      type = "string",
      minLength = 3,
      example = "Energy drink")
  private String description;

  @Schema(
      name = "metaTagTitle",
      description = "Product meta tag title",
      type = "string",
      minLength = 3,
      example = "energy-drink")
  private String metaTagTitle;

  @Schema(
      name = "metaTagDescription",
      description = "Product meta tag description",
      type = "string",
      minLength = 3,
      example = "Pepsi is an energy drink."
  )
  private String metaTagDescription;

  @Schema(
      name = "metaTagKeyword",
      description = "Product meta tag keyword",
      type = "string",
      minLength = 3,
      example = "pepsi, energy-drink"
  )
  private String metaTagKeyword;

  @Schema(
      name = "tag",
      description = "Product tag",
      type = "string",
      minLength = 3,
      example = "Pepsi, Energy drink"
  )
  private String tag;
}
