package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembersRepository extends BaseRepository<Member, Integer> {

//    @Query(value = "select ac.type , count(mb.id) from Member mb left join session_member ssmb on mb.id = ssmb.member_id " +
//            "left join Session ss on ssmb.session_id = ss.id " +
//            "left join member_role mbr on mb.id = mbr.member_id " +
//            "left join Role r on mbr.role_id = r.id " +
//            "left join Account_Role ar on ar.role_id = r.id " +
//            "left join Account ac on ar.account_id = ac.id " +
//            "left join Scanner sc on sc.id = ss.scanner_id " +
//            "left join Account sca on sca.id = sc.account_id " +
//            "where mb.id = ?1 and ac.type = sca.type" +
//            "group by ac.type ", nativeQuery = true)
//    List<Object[]> getMemberAttendanceOverAccount(long memberId);

    //@Query("SELECT a.type, COUNT(DISTINCT s) FROM Session s JOIN s.memberList m JOIN m.roles r JOIN r.accounts a WHERE m.id = :memberId group by a.type")

    @Query("select a.type, sum( (select count(s) from Session s join s.memberList sm where sm.id = m.id and s.scanner.id = a.scanner.id)) from Member m join m.roles r join r.accounts a where m.id = :memberId group by a.type")// Account a, Session s join s.scanner sc join s.memberList m JOIN m.roles r WHERE m.id = :memberId and r in elements(a.roles) GROUP BY a.type") // and a.scanner.id = s.scanner.id
    List<Object[]> getMemberAttendanceOverAccount( @Param("memberId") long memberId);
}
