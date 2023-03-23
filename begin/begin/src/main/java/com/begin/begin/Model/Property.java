package com.begin.begin.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Table(name = "properties")
@Entity
public class Property {
    @Id
    @Column(name = "propertyid")
    private int propertyId;
    @Column(name = "propertyname")
    private String propertyName;
    @Column(name = "propertysort")
    private int propertySort;
    @OneToMany(mappedBy = "property")
    @JsonIgnore
    private List<PropertyDetail> propertyDetails;
    @ManyToOne(optional = false)
    @JoinColumn(name = "productid")
    @JsonIgnore
    private Product product;

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertySort() {
        return propertySort;
    }

    public void setPropertySort(int propertySort) {
        this.propertySort = propertySort;
    }

    public List<PropertyDetail> getPropertyDetails() {
        return propertyDetails;
    }

    public void setPropertyDetails(List<PropertyDetail> propertyDetails) {
        this.propertyDetails = propertyDetails;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
