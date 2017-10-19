package com.flowable.entity;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Issue {

    @Id
    @GeneratedValue
    private Long id;

    private String barcode;

    private String orderId;

    private String apartmentId;

    private String productId;

    private String drawerId;

    private String accessoriesId;

    private String issueType;

    private String issueTypeDescription;

    private String issueLevel;

    private String issueLevelDescription;

    public Issue(String barcode, String orderId, String apartmentId, String productId, String drawerId, String accessoriesId, String issueType, String issueTypeDescription, String issueLevel, String issueLevelDescription) {
        this.barcode = barcode;
        this.orderId = orderId;
        this.apartmentId = apartmentId;
        this.productId = productId;
        this.drawerId = drawerId;
        this.accessoriesId = accessoriesId;
        this.issueType = issueType;
        this.issueTypeDescription = issueTypeDescription;
        this.issueLevel = issueLevel;
        this.issueLevelDescription = issueLevelDescription;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDrawerId() {
        return drawerId;
    }

    public void setDrawerId(String drawerId) {
        this.drawerId = drawerId;
    }

    public String getAccessoriesId() {
        return accessoriesId;
    }

    public void setAccessoriesId(String accessoriesId) {
        this.accessoriesId = accessoriesId;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getIssueTypeDescription() {
        return issueTypeDescription;
    }

    public void setIssueTypeDescription(String issueTypeDescription) {
        this.issueTypeDescription = issueTypeDescription;
    }

    public String getIssueLevel() {
        return issueLevel;
    }

    public void setIssueLevel(String issueLevel) {
        this.issueLevel = issueLevel;
    }

    public String getIssueLevelDescription() {
        return issueLevelDescription;
    }

    public void setIssueLevelDescription(String issueLevelDescription) {
        this.issueLevelDescription = issueLevelDescription;
    }
}
