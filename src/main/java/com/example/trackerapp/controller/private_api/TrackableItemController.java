package com.example.trackerapp.controller.private_api;

import com.example.trackerapp.entity.TrackableItem;
import com.example.trackerapp.service.TrackableItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
*
* 1) create item
* 2) delete item
* 3) update item name
*
*
* */
@RestController
@RequestMapping("/tracker")
public class TrackableItemController {
    private final TrackableItemService trackableItemService;
    public TrackableItemController(TrackableItemService trackableItemService) {
        this.trackableItemService = trackableItemService;
    }
    @GetMapping
    public List<TrackableItem> getTrackableItems() {
        return trackableItemService.findAllItems();
    }
    @PostMapping
    public TrackableItem createTrackableItem(@RequestBody TrackableItem trackableItem) {
        return trackableItemService.save(trackableItem);
    }
    @DeleteMapping("/{id}")
    public String deleteTrackableItem(@PathVariable Long id){
        trackableItemService.deleteById(id);
        return "Tracker deleted: "+id;
    }
    @PutMapping("/{id}")
    public String updateTrackableItem(@PathVariable Long id, @RequestBody TrackableItem newItem){
        trackableItemService.update(id, newItem);
        return "Tracker updated: "+id;
    }
}
