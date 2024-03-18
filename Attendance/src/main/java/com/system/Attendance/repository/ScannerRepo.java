package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanners;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScannerRepo extends BaseRepository<Scanners, Integer> {

}
