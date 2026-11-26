
package com.example.MotoManager.controller;

import com.example.MotoManager.dto.MaintenanceRecordRequest;
import com.example.MotoManager.entity.MaintenanceRecord;
import com.example.MotoManager.service.MaintenanceRecordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance-records")
public class MaintenanceRecordController {

    private final MaintenanceRecordService maintenanceRecordService;

    public MaintenanceRecordController(
            MaintenanceRecordService maintenanceRecordService) {
        this.maintenanceRecordService = maintenanceRecordService;
    }

    @GetMapping
    public List<MaintenanceRecord> findAll() {
        return maintenanceRecordService.findAll();
    }

    @PostMapping
    public MaintenanceRecord save(@RequestBody MaintenanceRecordRequest request) {

        MaintenanceRecord record = new MaintenanceRecord();

        record.setMaintenanceDate(request.getMaintenanceDate());
        record.setMaintenanceName(request.getMaintenanceName());
        record.setMileage(request.getMileage());
        record.setCost(request.getCost());
        record.setMemo(request.getMemo());

        return maintenanceRecordService.save(record, request.getMotorcycleId());
    }

    @PutMapping("/{id}")
    public MaintenanceRecord update(
            @PathVariable Long id,
            @RequestBody MaintenanceRecordRequest request) {

        MaintenanceRecord record = new MaintenanceRecord();

        record.setMaintenanceDate(request.getMaintenanceDate());
        record.setMaintenanceName(request.getMaintenanceName());
        record.setMileage(request.getMileage());
        record.setCost(request.getCost());
        record.setMemo(request.getMemo());

        return maintenanceRecordService.update(
                id, record, request.getMotorcycleId());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        maintenanceRecordService.delete(id);
    }
}
