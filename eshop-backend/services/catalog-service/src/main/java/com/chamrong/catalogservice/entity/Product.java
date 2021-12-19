package com.chamrong.catalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"barcode"})})
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Size(min = 3, message = "Product name should have 3 characters")
  @NotBlank
  private String name;

  @Size(min = 7, max = 7, message = "Product barcode should have 7 characters")
  @NotBlank
  private String barcode;

  @Size(min = 3, message = "Product description should have at least 3 characters")
  @NotBlank
  private String description;

  @Size(min = 3, message = "Product meta tag title should have at least 3 characters")
  @NotBlank
  private String metaTagTitle;

  @Size(min = 3, message = "Product meta description title should have at least 3 characters")
  @NotBlank
  private String metaTagDescription;

  @Size(min = 3, message = "Product meta keyword title should have at least 3 characters")
  @NotBlank
  private String metaTagKeyword;

  @Size(min = 3, message = "Product tag should have at least 3 characters")
  @NotBlank
  private String tag;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Product product = (Product) o;
    return id != null && Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
