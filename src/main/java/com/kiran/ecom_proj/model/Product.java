package com.kiran.ecom_proj.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
 private String name;
 private String description;
 private String brand;
 private BigDecimal price;
 private String category;

// @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM-dd-yyyy")
 private Date releaseDate;
 private boolean available;
 private String quantity;

 private String imageName;
 private String imageType;
 @Lob
 private byte[] imageDate;


 public String getImageName() {
  return imageName;
 }

 public void setImageName(String imageName) {
  this.imageName = imageName;
 }

 public String getImageType() {
  return imageType;
 }

 public void setImageType(String imageType) {
  this.imageType = imageType;
 }

 public byte[] getImageDate() {
  return imageDate;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getDescription() {
  return description;
 }

 public void setDescription(String description) {
  this.description = description;
 }

 public String getBrand() {
  return brand;
 }

 public void setBrand(String brand) {
  this.brand = brand;
 }

 public BigDecimal getPrice() {
  return price;
 }

 public void setPrice(BigDecimal price) {
  this.price = price;
 }

 public String getCategory() {
  return category;
 }

 public void setCategory(String category) {
  this.category = category;
 }

 public Date getReleaseDate() {
  return releaseDate;
 }

 public void setReleaseDate(Date releaseDate) {
  this.releaseDate = releaseDate;
 }

 public boolean isAvailable() {
  return available;
 }

 public void setAvailable(boolean available) {
  this.available = available;
 }

 public String getQuantity() {
  return quantity;
 }

 public void setQuantity(String quantity) {
  this.quantity = quantity;
 }

 public void setImageDate(byte[] imageDate) {
  this.imageDate = imageDate;
 }
}