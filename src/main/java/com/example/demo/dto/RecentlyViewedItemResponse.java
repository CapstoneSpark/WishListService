package com.example.demo.dto;
import java.time.LocalDateTime;
public class RecentlyViewedItemResponse {
	private Long id;
    private Long userId;
    private Long productId;
    private LocalDateTime viewedAt;

    public RecentlyViewedItemResponse() {
    }

    public RecentlyViewedItemResponse(Long id, Long userId, Long productId, LocalDateTime viewedAt) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.viewedAt = viewedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getViewedAt() {
        return viewedAt;
    }

    public void setViewedAt(LocalDateTime viewedAt) {
        this.viewedAt = viewedAt;
    }
}

