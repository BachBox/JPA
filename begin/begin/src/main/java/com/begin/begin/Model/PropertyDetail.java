package com.begin.begin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "propertydetails")
public class PropertyDetail {
    @Id
    @Column(name = "propertydetailid")
    private int propertyDetailId;
    @Column(name = "propertydetailcode")
    private String propertyDetailCode;
    @Column(name = "propertydetaildetail")
    private String propertyDetailDetail;
    @ManyToOne(optional = false)
    @JsonIgnore
    @JoinColumn(name = "propertyid")
    private Property property;
    @OneToMany(mappedBy = "propertyDetail")
    @JsonIgnore
    private List<ProductDetailPropertyDetail> productDetailPropertyDetails;

    public int getPropertyDetailId() {
        return propertyDetailId;
    }

    public void setPropertyDetailId(int propertyDetailId) {
        this.propertyDetailId = propertyDetailId;
    }

    public String getPropertyDetailCode() {
        return propertyDetailCode;
    }

    public void setPropertyDetailCode(String propertyDetailCode) {
        this.propertyDetailCode = propertyDetailCode;
    }

    public String getPropertyDetailDetail() {
        return propertyDetailDetail;
    }

    public void setPropertyDetailDetail(String propertyDetailDetail) {
        this.propertyDetailDetail = propertyDetailDetail;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public List<ProductDetailPropertyDetail> getProductDetailPropertyDetails() {
        return productDetailPropertyDetails;
    }

    public void setProductDetailPropertyDetails(List<ProductDetailPropertyDetail> productDetailPropertyDetails) {
        this.productDetailPropertyDetails = productDetailPropertyDetails;
    }
}
