package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface MemberRepository extends BaseRepository<Member, Integer>{

    @Query(value = "select ac.type , count(mb.id) from Member mb left join session_member ssmb on mb.id = ssmb.member_id " +
            "left join Session ss on ssmb.session_id = ss.id " +
            "left join member_role mbr on mb.id = mbr.member_id " +
            "left join Role r on mbr.role_id = r.id " +
            "left join Account_Role ar on ar.role_id = r.id " +
            "left join Account ac on ar.account_id = ac.id " +
            "left join Scanner sc on sc.id = ss.scanner_id " +
            "left join Account sca on sca.id = sc.account_id " +
            "where mb.id = ?1 and ac.type = sca.type" +
            "group by ac.type ", nativeQuery = true)
    List<Object[]> getMemberAttendanceOverAccount(long memberId);
}
