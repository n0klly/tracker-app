package com.example.trackerapp.service;

import com.example.trackerapp.entity.DailyLog;
import com.example.trackerapp.entity.TrackableItem;
import com.example.trackerapp.repository.DailyLogRepository;
import com.example.trackerapp.repository.TrackableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyLogService {
    DailyLogRepository dailyLogRepository;
    public DailyLogService(DailyLogRepository dailyLogRepository){
        this.dailyLogRepository = dailyLogRepository;
    }
    public List<DailyLog> findAllDailyLogs(){
        return dailyLogRepository.findAll();
    }
    public DailyLog save(DailyLog dailyLog){
        return dailyLogRepository.save(dailyLog);
    }
    public void update(Long logId, DailyLog dailyLog){
        DailyLog log = dailyLogRepository.findById(logId).orElseThrow(() ->
                new RuntimeException("Element is not exist"));
        log.setLogValue(dailyLog.getLogValue());
        dailyLogRepository.save(log);
    }

}
