package com.example.MotoManager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.MotoManager.entity.Motorcycle;
import com.example.MotoManager.repository.MotorcycleRepository;

import jakarta.websocket.server.ServerEndpoint;

@Service
public class MotorcycleService {
    private final MotorcycleRepository motorcycleRepository;

    public MotorcycleService(MotorcycleRepository motorcycleRepository) {
        this.motorcycleRepository = motorcycleRepository;
    }

    public Motorcycle save(Motorcycle motorcycle) {
        return motorcycleRepository.save(motorcycle);
    }

    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    public Motorcycle update(Long id, Motorcycle motorcycle) {
        Motorcycle existing = motorcycleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("バイクが見つかりません"));

        existing.setName(motorcycle.getName());
        existing.setManufacturer(motorcycle.getManufacturer());
        existing.setYear(motorcycle.getYear());
        existing.setMileage(motorcycle.getMileage());

        return motorcycleRepository.save(existing);
    }

}
