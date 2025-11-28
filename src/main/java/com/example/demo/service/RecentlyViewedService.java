package com.example.demo.service;
import com.example.demo.dto.RecentlyViewedItemResponse;
import com.example.demo.dto.RecentlyViewedRequest;
import com.example.demo.entity.RecentlyViewedItem;
import com.example.demo.repository.RecentlyViewedItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecentlyViewedService {
private final RecentlyViewedItemRepository recentlyViewedItemRepository;

public RecentlyViewedService(RecentlyViewedItemRepository recentlyViewedItemRepository) {
    this.recentlyViewedItemRepository = recentlyViewedItemRepository;
}

public RecentlyViewedItemResponse trackView(RecentlyViewedRequest request) {
    RecentlyViewedItem item = new RecentlyViewedItem();
    item.setUserId(request.getUserId());
    item.setProductId(request.getProductId());
    item.setViewedAt(LocalDateTime.now());

    RecentlyViewedItem saved = recentlyViewedItemRepository.save(item);

    return new RecentlyViewedItemResponse(
            saved.getId(),
            saved.getUserId(),
            saved.getProductId(),
            saved.getViewedAt()
    );
}

public List<RecentlyViewedItemResponse> getRecentViewsForUser(Long userId) {
    List<RecentlyViewedItem> list =
            recentlyViewedItemRepository.findTop20ByUserIdOrderByViewedAtDesc(userId);

    return list.stream()
            .map(i -> new RecentlyViewedItemResponse(
                    i.getId(),
                    i.getUserId(),
                    i.getProductId(),
                    i.getViewedAt()
            ))
            .collect(Collectors.toList());
}
}

