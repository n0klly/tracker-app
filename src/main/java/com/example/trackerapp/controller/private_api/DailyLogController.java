package com.example.trackerapp.controller.private_api;

import com.example.trackerapp.entity.DailyLog;
import com.example.trackerapp.service.DailyLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class DailyLogController {

    DailyLogService dailyLogService;
    public DailyLogController(DailyLogService dailyLogService){
        this.dailyLogService = dailyLogService;
    }

    @GetMapping
    public List<DailyLog> getDailyLogs(){
        return dailyLogService.findAllDailyLogs();
    }
    @PostMapping
    public DailyLog createDailyLog(@RequestBody DailyLog dailyLog){
        return dailyLogService.save(dailyLog);
    }
    @PutMapping("/{logId}")
    public String updateDailyLog(@PathVariable Long logId, @RequestBody DailyLog dailyLog){
         dailyLogService.update(logId, dailyLog);
        return "Log updated: "+logId;
    }
}
