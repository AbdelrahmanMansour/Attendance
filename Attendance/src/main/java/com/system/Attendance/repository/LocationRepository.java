package com.system.Attendance.repository;

import com.system.Attendance.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
