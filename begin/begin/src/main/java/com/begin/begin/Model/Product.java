package com.begin.begin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "productid")
    private int productId;
    @Column(name = "productname")
    private String productName;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<Property> properties;
    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private List<ProductDetailPropertyDetail> productDetailPropertyDetails;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public List<ProductDetailPropertyDetail> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(List<ProductDetailPropertyDetail> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }
}
