package com.example.trackerapp.repository;

import com.example.trackerapp.entity.DailyLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyLogRepository extends JpaRepository<DailyLog, Long> {

}
