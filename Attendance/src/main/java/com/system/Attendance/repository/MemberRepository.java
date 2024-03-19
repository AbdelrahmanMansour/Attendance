package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MemberRepository extends BaseRepository<Member, Integer>{

    @Query("SELECT COUNT(DISTINCT s.id) " +
            "FROM Member m " +
            "JOIN m.eventList e " +
            "JOIN e.schedule sch " +
            "JOIN sch.sessions s " +
            "LEFT JOIN s.memberList sm " +
            "WHERE m.id = :memberId " +
            "AND e.id = :eventId")
    int countAttendanceByMemberIdAndEventId(@Param("memberId") Long memberId, @Param("eventId") Long eventId);

}
