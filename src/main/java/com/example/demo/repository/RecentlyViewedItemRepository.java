package com.example.demo.repository;
import com.example.demo.entity.RecentlyViewedItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface RecentlyViewedItemRepository extends JpaRepository<RecentlyViewedItem, Long>{

    List<RecentlyViewedItem> findTop20ByUserIdOrderByViewedAtDesc(Long userId);
}

