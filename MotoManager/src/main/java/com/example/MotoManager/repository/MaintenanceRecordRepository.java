package com.example.MotoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MotoManager.entity.MaintenanceRecord;

public interface MaintenanceRecordRepository extends JpaRepository<MaintenanceRecord, Long> {

}
