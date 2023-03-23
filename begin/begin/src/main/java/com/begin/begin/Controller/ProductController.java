package com.begin.begin.Controller;

import com.begin.begin.Model.Product;
import com.begin.begin.Model.ProductDetail;
import com.begin.begin.Model.ProductDetailPropertyDetail;
import com.begin.begin.Model.PropertyDetail;
import com.begin.begin.Repository.ProductDetailPropertyDetailRepository;
import com.begin.begin.Repository.ProductDetailRepository;
import com.begin.begin.Repository.ProductRepository;
import com.begin.begin.Repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    PropertyRepository propertyRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;
    @Autowired
    ProductDetailPropertyDetailRepository productDetailPropertyDetailRepository;
    @PutMapping(value = "product/sell")
    public void sellProduct(@RequestParam int productDetailPropertyDetailId, int quantity){
        Optional<ProductDetailPropertyDetail> optional = productDetailPropertyDetailRepository.findById(productDetailPropertyDetailId);
        if(optional.isPresent()){
            ProductDetailPropertyDetail productDetailPropertyDetail = optional.get();
            ProductDetail productDetail = productDetailRepository.findById(productDetailPropertyDetail.getProductDetail().getProductDetailId()).get();
            if(productDetail.getQuantity() < quantity){
                System.out.println("Khong du sl ban");
                return;
            }else {
                // Assign a var to the tail of ProductDetail
                ProductDetail curProduct = productDetail;
                curProduct.setQuantity(curProduct.getQuantity() - quantity);
                productDetailRepository.save(curProduct);
                while (curProduct.getProductDetail() != null) {
                    curProduct = productDetailRepository.findById(curProduct.getProductDetail().getProductDetailId()).get();
                    curProduct.setQuantity(curProduct.getQuantity() - quantity);
                    productDetailRepository.save(curProduct);
                }
            }
        }
    }
    @PutMapping(value = "product/update")
    public void updateProduct(@RequestParam int productDetailPropertyDetailId, int quantity){
        if(quantity < 0){
            System.out.println("So luong cap nhat ko the < 0");
            return;
        }
        Optional<ProductDetailPropertyDetail> optional = productDetailPropertyDetailRepository.findById(productDetailPropertyDetailId);
        if(optional.isPresent()){
            ProductDetailPropertyDetail productDetailPropertyDetail = optional.get();
            ProductDetail productDetail = productDetailRepository.findById(productDetailPropertyDetail.getProductDetail().getProductDetailId()).get();
            if(productDetail.getQuantity() > quantity){
                int diff = productDetail.getQuantity() - quantity;
                productDetail.setQuantity(quantity);
                productDetailRepository.save(productDetail);

                ProductDetail curProduct = productDetail;
                while (curProduct.getProductDetail() != null) {
                    curProduct = productDetailRepository.findById(curProduct.getProductDetail().getProductDetailId()).get();
                    curProduct.setQuantity(curProduct.getQuantity() - diff);
                    productDetailRepository.save(curProduct);
                }
            }else {
                int diff = quantity - productDetail.getQuantity();
                productDetail.setQuantity(quantity);
                productDetailRepository.save(productDetail);

                ProductDetail curProduct = productDetail;
                while (curProduct.getProductDetail() != null) {
                    curProduct = productDetailRepository.findById(curProduct.getProductDetail().getProductDetailId()).get();
                    curProduct.setQuantity(curProduct.getQuantity() + diff);
                    productDetailRepository.save(curProduct);
                }
            }
        }
    }

    @GetMapping(value = "productdetails/get")
    public Set<ProductDetail> getDetails() {
        Set<ProductDetail> productDetailSet = new HashSet<>();
        for (var x : productDetailPropertyDetailRepository.findAll()) {
            productDetailSet.add(x.getProductDetail());
        }
        return productDetailSet;
    }

}
