package com.launchacademy.orders.models;

import javax.validation.constraints.NotNull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.*;


@Entity
@Table(name="orders")
public class Order {
  @Id
  @SequenceGenerator(name="order_generator",sequenceName = "orders_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
  @Column(name="id",nullable =false, unique=true)
  private Long id;

  @NotEmpty
  @Column(name="username", nullable=false)
  private String username;

  @NotEmpty
  @Column(name="item_name", nullable=false)
  private String itemName;

  @NotNull
  @Column(name="item_quantity", nullable= false)
  private Integer itemQuantity;

  @NotNull
  @Column(name="gluten_free", nullable = false)
  private Boolean glutenFree;

  @NotEmpty
  @Column(name="image_url", nullable = false)
  private String imageUrl;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  public Integer getItemQuantity() {
    return itemQuantity;
  }

  public void setItemQuantity(Integer itemQuantity) {
    this.itemQuantity = itemQuantity;
  }

  public Boolean getGlutenFree() {
    return glutenFree;
  }

  public void setGlutenFree(Boolean glutenFree) {
    this.glutenFree = glutenFree;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }
}
