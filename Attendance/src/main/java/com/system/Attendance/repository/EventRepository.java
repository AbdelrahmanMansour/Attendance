package com.system.Attendance.repository;

import com.system.Attendance.domain.Event;
import com.system.Attendance.enums.AccountType;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {
    @Query("SELECT e FROM Event e JOIN e.account a WHERE a.id = :accountId")
    List<Event> findByAccount(@Param("accountId") Long accountId);
}
