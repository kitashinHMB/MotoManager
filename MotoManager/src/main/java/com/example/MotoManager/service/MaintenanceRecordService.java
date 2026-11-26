
package com.example.MotoManager.service;

import com.example.MotoManager.entity.MaintenanceRecord;
import com.example.MotoManager.entity.Motorcycle;
import com.example.MotoManager.repository.MaintenanceRecordRepository;
import com.example.MotoManager.repository.MotorcycleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceRecordService {

    private final MaintenanceRecordRepository maintenanceRecordRepository;
    private final MotorcycleRepository motorcycleRepository;

    public MaintenanceRecordService(
            MaintenanceRecordRepository maintenanceRecordRepository,
            MotorcycleRepository motorcycleRepository) {
        this.maintenanceRecordRepository = maintenanceRecordRepository;
        this.motorcycleRepository = motorcycleRepository;
    }

    public MaintenanceRecord save(MaintenanceRecord record, Long motorcycleId) {
        Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
                .orElseThrow(() -> new RuntimeException("バイクが見つかりません"));

        record.setMotorcycle(motorcycle);

        return maintenanceRecordRepository.save(record);
    }

    public List<MaintenanceRecord> findAll() {
        return maintenanceRecordRepository.findAll();
    }

    public MaintenanceRecord update(
            Long id, MaintenanceRecord record, Long motorcycleId) {

        MaintenanceRecord existing = maintenanceRecordRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("整備記録が見つかりません"));

        Motorcycle motorcycle = motorcycleRepository.findById(motorcycleId)
                .orElseThrow(() -> new RuntimeException("バイクが見つかりません"));

        existing.setMotorcycle(motorcycle);
        existing.setMaintenanceDate(record.getMaintenanceDate());
        existing.setMaintenanceName(record.getMaintenanceName());
        existing.setMileage(record.getMileage());
        existing.setCost(record.getCost());
        existing.setMemo(record.getMemo());

        return maintenanceRecordRepository.save(existing);
    }

    public void delete(Long id) {
        if (!maintenanceRecordRepository.existsById(id)) {
            throw new RuntimeException("整備記録が見つかりません");
        }

        maintenanceRecordRepository.deleteById(id);
    }
}
