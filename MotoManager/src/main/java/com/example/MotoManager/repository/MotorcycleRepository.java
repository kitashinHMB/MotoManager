package com.example.MotoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MotoManager.entity.Motorcycle;

public interface MotorcycleRepository extends JpaRepository<Motorcycle, Long> {

}
