package com.example.demo.service;
import com.example.demo.dto.WishlistItemResponse;
import com.example.demo.dto.WishlistRequest;
import com.example.demo.entity.WishlistItem;
import com.example.demo.repository.WishlistItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WishlistService {
	 private final WishlistItemRepository wishlistItemRepository;

	    public WishlistService(WishlistItemRepository wishlistItemRepository) {
	        this.wishlistItemRepository = wishlistItemRepository;
	    }

	    public WishlistItemResponse addToWishlist(WishlistRequest request) {
	        // prevent duplicate entries
	        if (wishlistItemRepository.existsByUserIdAndProductId(request.getUserId(), request.getProductId())) {
	            WishlistItem existing = wishlistItemRepository
	                    .findByUserIdAndProductId(request.getUserId(), request.getProductId())
	                    .orElse(null);
	            if (existing != null) {
	                return new WishlistItemResponse(
	                        existing.getId(),
	                        existing.getUserId(),
	                        existing.getProductId(),
	                        existing.getAddedAt()
	                );
	            }
	        }

	        WishlistItem item = new WishlistItem();
	        item.setUserId(request.getUserId());
	        item.setProductId(request.getProductId());
	        item.setAddedAt(LocalDateTime.now());

	        WishlistItem saved = wishlistItemRepository.save(item);

	        return new WishlistItemResponse(
	                saved.getId(),
	                saved.getUserId(),
	                saved.getProductId(),
	                saved.getAddedAt()
	        );
	    }

	    public List<WishlistItemResponse> getWishlistForUser(Long userId) {
	        List<WishlistItem> items = wishlistItemRepository.findByUserIdOrderByAddedAtDesc(userId);

	        return items.stream()
	                .map(i -> new WishlistItemResponse(
	                        i.getId(),
	                        i.getUserId(),
	                        i.getProductId(),
	                        i.getAddedAt()
	                ))
	                .collect(Collectors.toList());
	    }

	    public void removeFromWishlist(Long userId, Long productId) {
	        wishlistItemRepository.deleteByUserIdAndProductId(userId, productId);
	    }
	    
	    public void removeItemById(Long id) {
	        if (!wishlistItemRepository.existsById(id)) {
	            throw new RuntimeException("Wishlist item not found");
	        }
	        wishlistItemRepository.deleteById(id);
	    }

	}

