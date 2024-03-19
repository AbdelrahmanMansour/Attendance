package com.system.Attendance.repository;

import com.system.Attendance.domain.*;
import com.system.Attendance.enums.AccountType;
import com.system.Attendance.enums.LocationType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void getMemberAttendanceOverAccount() {
        Account eating = new Account("eating","eating account", AccountType.EATING);
        Account virtualDolar = new Account("virtual Dolar","Virtual Dolar", AccountType.VIRTUAL_DOLLAR);
        entityManager.persist(eating);
        entityManager.persist(virtualDolar);

        Location daibyHall = new Location("location", "eatting location", LocationType.DINING);
        entityManager.persist(daibyHall);
        Scanner scanner = new Scanner("code",daibyHall, eating );
        entityManager.persist(scanner);
        // create role
        Role role = new Role("student", "student role");

        // set relation between role and account
        eating.addRole(role);
        virtualDolar.addRole(role);
        role.addAccount(eating);
        role.addAccount(virtualDolar);
        entityManager.persist(role);

        // create member
        Member member = new Member("student1","first name", "last name","1111", 1000.0, "email");
        member.setRoles(Arrays.asList(role));
        role.addMember(member);
        Member savedMember = entityManager.persist(member);

        // create session
        Session session = new Session(LocalDateTime.now(), LocalDateTime.now());
        Session session2 = new Session(LocalDateTime.now(), LocalDateTime.now());
        // same scanner
        session.setScanner(scanner);
        session2.setScanner(scanner);

        session.addMember(member);
        session.addMember(member);
        member.setSessionList(Arrays.asList(session, session2));

        entityManager.persist(session);
        entityManager.persist(session2);
        entityManager.flush();

        List<Object[]> expectedResult = new ArrayList<>();
        Object[] array1 = new Object[2];
        Object[] array2 = new Object[2];
        array1[0] = "EATING";
        array1[1] = 2;
        array2[0] = "VIRTUAL_DOLLAR";
        array2[1] = 0;
        expectedResult.add(array1);
        expectedResult.add(array2);

        List<Object[]> repoResult = memberRepository.getMemberAttendanceOverAccount(savedMember.getId());

        assertThat(2).isEqualTo(repoResult.size());


    }
}