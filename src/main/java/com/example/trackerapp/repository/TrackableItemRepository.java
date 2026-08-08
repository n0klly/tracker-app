package com.example.trackerapp.repository;

import com.example.trackerapp.entity.TrackableItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackableItemRepository extends JpaRepository<TrackableItem, Long> {

    boolean existsByName(String itemName);
}
