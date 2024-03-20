package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Session;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MembersRepository extends BaseRepository<Member, Integer> {

//    @Query("SELECT s FROM Session s JOIN s. m WHERE m.id = ?1")
//    List<Session> getRecordsByScannerCode(Integer scannerCode);

}
