package com.example.trackerapp.service;

import com.example.trackerapp.entity.TrackableItem;
import com.example.trackerapp.repository.TrackableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackableItemService {
    private final TrackableItemRepository trackableItemRepository;
    public TrackableItemService(TrackableItemRepository trackableItemRepository) {
        this.trackableItemRepository = trackableItemRepository;
    }
    public List<TrackableItem> findAllItems() {
        return trackableItemRepository.findAll();
    }
    public TrackableItem save(TrackableItem trackableItem) {
        if(trackableItemRepository.existsByName(trackableItem.getName())){
            throw new IllegalArgumentException("Item:'" + trackableItem.getName()
                    + "' already exist!");
        }
        return trackableItemRepository.save(trackableItem);
    }
    public void deleteById(Long id){
        trackableItemRepository.deleteById(id);
    }
    public void update(Long id, TrackableItem newItem){
        TrackableItem Item = trackableItemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Element is not exist"));
        Item.setName(newItem.getName());
        Item.setType(newItem.getType());
        trackableItemRepository.save(Item);
    }
}
