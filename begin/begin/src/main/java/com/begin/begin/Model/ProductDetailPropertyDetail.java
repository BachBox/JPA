package com.begin.begin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Productdetailpropertydetails")
public class ProductDetailPropertyDetail {
    @Id
    @Column(name = "productdetailpropertydetailid")
    private int productDetailPropertyDetailId;
    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "productdetailid")
    private ProductDetail productDetail;
    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "propertydetailid")
    private PropertyDetail propertyDetail;
    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "productid")
    private Product product;

    public int getProductDetailPropertyDetailId() {
        return productDetailPropertyDetailId;
    }

    public void setProductDetailPropertyDetailId(int productDetailPropertyDetailId) {
        this.productDetailPropertyDetailId = productDetailPropertyDetailId;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public PropertyDetail getPropertyDetail() {
        return propertyDetail;
    }

    public void setPropertyDetail(PropertyDetail propertyDetail) {
        this.propertyDetail = propertyDetail;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
