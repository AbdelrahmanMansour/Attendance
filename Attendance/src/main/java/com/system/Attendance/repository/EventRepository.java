package com.system.Attendance.repository;

import com.system.Attendance.domain.Event;
import com.system.Attendance.domain.Session;
import com.system.Attendance.enums.AccountType;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {
    @Query("SELECT e FROM Event e JOIN e.account a WHERE a.id = :accountId")
    List<Event> findByAccount(@Param("accountId") Long accountId);

//    @Query(value = "SELECT s.* FROM Session s JOIN Schedule sch ON s.schedule_id = sch.id JOIN Event e ON sch.id = e.schedule_id WHERE e.id = :eventId", nativeQuery = true)
//    List<Session> fintSessionsByEventId(@Param("eventId") Long eventId);

    @Query("SELECT s FROM Event e JOIN e.schedule sch JOIN sch.sessions s WHERE e.id = :eventId")
    List<Session> findSessionsByEventIdjpql(@Param("eventId") Long eventId);
}
