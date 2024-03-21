package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MembersRepository extends BaseRepository<Member, Integer> {

    List<Member> findByBalanceLessThan(Double balance);

    //@Query("SELECT a.type, COUNT(DISTINCT s) FROM Session s JOIN s.memberList m JOIN m.roles r JOIN r.accounts a WHERE m.id = :memberId group by a.type")

    @Query("select a.type, sum( (select count(s) from Scanner sn join sn.sessions s join s.memberList sm where sm.id = m.id and sn.id = a.id)) from Member m join m.roles r join r.accounts a where m.id = :memberId group by a.type")// Account a, Session s join s.scanner sc join s.memberList m JOIN m.roles r WHERE m.id = :memberId and r in elements(a.roles) GROUP BY a.type") // and a.scanner.id = s.scanner.id
    List<Object[]> getMemberAttendanceOverAccount( @Param("memberId") long memberId);
}
