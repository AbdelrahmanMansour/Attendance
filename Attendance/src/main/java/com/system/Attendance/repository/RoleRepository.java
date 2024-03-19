package com.system.Attendance.repository;

import com.system.Attendance.domain.Role;
import edu.miu.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends BaseRepository<Role, Integer> {

    @Modifying
    @Query(value = "DELETE FROM member_role WHERE role_id in (:roleIds)", nativeQuery = true)
    void deleteAllRoleRefsInMemberRole(Iterable<Integer> roleIds);

}
