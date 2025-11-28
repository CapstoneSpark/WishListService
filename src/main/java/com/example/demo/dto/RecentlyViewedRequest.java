package com.example.demo.dto;

public class RecentlyViewedRequest {

    private Long userId;
    private Long productId;

    public RecentlyViewedRequest() {
    }

    public RecentlyViewedRequest(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}

