package com.system.Attendance.repository;

import com.system.Attendance.domain.Member;
import edu.miu.common.repository.BaseRepository;

import java.util.List;

public interface MembersRepository extends BaseRepository<Member, Integer> {

    List<Member> findByBalanceLessThan(Double balance);

}
