package com.begin.begin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

import java.util.List;

@Entity
@Table(name = "productdetails")
public class ProductDetail {
    @Id
    @Column(name = "productdetailid")
    private int productDetailId;
    @Column(name = "productdetailname")
    private String productDetailName;
    @Column(name = "quantity")
    @Min(value = 0, message = "So luong sp < 0, ko ban duoc nua")
    private int quantity;
    @Column(name = "price")
    private float price;
    @Column(name = "shellprice")
    private float shellPrice;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "parentid")
    private ProductDetail productDetail;
    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private List<ProductDetailPropertyDetail> productDetailPropertyDetails;

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getProductDetailName() {
        return productDetailName;
    }

    public void setProductDetailName(String productDetailName) {
        this.productDetailName = productDetailName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getShellPrice() {
        return shellPrice;
    }

    public void setShellPrice(float shellPrice) {
        this.shellPrice = shellPrice;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public List<ProductDetailPropertyDetail> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(List<ProductDetailPropertyDetail> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "productDetailId=" + productDetailId +
                ", productDetailName='" + productDetailName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", shellPrice=" + shellPrice +
                ", productDetail=" + productDetail +
                ", productDetailPropertyDetails=" + productDetailPropertyDetails +
                '}';
    }
}
