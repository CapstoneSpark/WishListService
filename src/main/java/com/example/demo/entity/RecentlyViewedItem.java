package com.example.demo.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "recently_viewed_items")
public class RecentlyViewedItem {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "user_id", nullable = false)
	    private Long userId;

	    @Column(name = "product_id", nullable = false)
	    private Long productId;

	    @Column(name = "viewed_at", nullable = false)
	    private LocalDateTime viewedAt;

	    public RecentlyViewedItem() {
	    }

	    public RecentlyViewedItem(Long id, Long userId, Long productId, LocalDateTime viewedAt) {
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

