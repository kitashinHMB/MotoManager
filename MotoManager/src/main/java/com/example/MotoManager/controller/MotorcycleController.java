package com.example.MotoManager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.MotoManager.entity.Motorcycle;
import com.example.MotoManager.service.MotorcycleService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    public MotorcycleController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public List<Motorcycle> findAll() {
        return motorcycleService.findAll();
    }

    @PostMapping
    public Motorcycle save(@RequestBody Motorcycle motorcycle) {
        return motorcycleService.save(motorcycle);
    }

}
