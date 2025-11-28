package com.example.demo.controller;
import com.example.demo.dto.*;
import com.example.demo.service.RecentlyViewedService;
import com.example.demo.service.WishlistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class WishlistRecentlyViewedController {

    private final WishlistService wishlistService;
    private final RecentlyViewedService recentlyViewedService;

    public WishlistRecentlyViewedController(WishlistService wishlistService,
                                            RecentlyViewedService recentlyViewedService) {
        this.wishlistService = wishlistService;
        this.recentlyViewedService = recentlyViewedService;
    }

    // -------- WISHLIST --------

    @PostMapping("/wishlist/add")
    public ResponseEntity<WishlistItemResponse> addToWishlist(@RequestBody WishlistRequest request) {
        WishlistItemResponse response = wishlistService.addToWishlist(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/wishlist/user/{userId}")
    public ResponseEntity<List<WishlistItemResponse>> getWishlist(@PathVariable Long userId) {
        List<WishlistItemResponse> list = wishlistService.getWishlistForUser(userId);
        return ResponseEntity.ok(list);
    }

//    @DeleteMapping("/wishlist/remove")
//    public ResponseEntity<Void> removeFromWishlist(
//            @RequestParam Long userId,
//            @RequestParam Long productId) {
//
//        wishlistService.removeFromWishlist(userId, productId);
//        return ResponseEntity.noContent().build();
//    }
//    
    @DeleteMapping("/wishlist/remove/{id}")
    public ResponseEntity<Void> removeFromWishlist(@PathVariable Long id) {
        wishlistService.removeItemById(id);
        return ResponseEntity.noContent().build();
    }


    // -------- RECENTLY VIEWED --------

    @PostMapping("/recently-viewed/track")
    public ResponseEntity<RecentlyViewedItemResponse> trackView(
            @RequestBody RecentlyViewedRequest request) {

        RecentlyViewedItemResponse response = recentlyViewedService.trackView(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/recently-viewed/user/{userId}")
    public ResponseEntity<List<RecentlyViewedItemResponse>> getRecentViews(
            @PathVariable Long userId) {

        List<RecentlyViewedItemResponse> list = recentlyViewedService.getRecentViewsForUser(userId);
        return ResponseEntity.ok(list);
    }
}

