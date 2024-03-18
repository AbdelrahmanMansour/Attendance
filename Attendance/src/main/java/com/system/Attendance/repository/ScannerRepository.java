package com.system.Attendance.repository;

import com.system.Attendance.domain.Scanners;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScannerRepository extends JpaRepository<Scanners, Integer> {
}
