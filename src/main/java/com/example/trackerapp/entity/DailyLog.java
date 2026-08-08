package com.example.trackerapp.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class DailyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(updatable = false)
    private Date date;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private TrackableItem trackableItem;

    @Column(name = "log_value")
    private String logValue;

    public TrackableItem getTrackableItem() {
        return trackableItem;
    }

    public void setTrackableItem(TrackableItem trackableItem) {
        this.trackableItem = trackableItem;
    }

    public String getLogValue() {
        return logValue;
    }

    public void setLogValue(String logValue) {
        this.logValue = logValue;
    }
}
