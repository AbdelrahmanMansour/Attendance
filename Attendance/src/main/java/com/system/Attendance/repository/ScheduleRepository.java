package com.system.Attendance.repository;

import com.sun.jna.platform.win32.WinUser;
import com.system.Attendance.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
}
