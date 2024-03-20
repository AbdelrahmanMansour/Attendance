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

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    MembersRepository memberRepository;
    @Test
    public void getMemberAttendanceOverAccount() {

        Location daibyHall = new Location("location", "eatting location", LocationType.DINING);
        entityManager.persist(daibyHall);
        Scanner scanner = new Scanner(daibyHall);
        entityManager.persist(scanner);

        Account eating = new Account("eating","eating account", AccountType.EATING);
        Account virtualDolar = new Account("virtual Dolar","Virtual Dolar", AccountType.VIRTUAL_DOLLAR);
        entityManager.persist(eating);
        entityManager.persist(virtualDolar);

        eating.setScanner(scanner);
        // create role
        Role role = new Role("student", "student role");

        // set relation between role and account
        role.setAccounts(Arrays.asList(eating, virtualDolar));
        entityManager.persist(role);

        // create member
        Member member = new Member("student1","first name", "last name","1111", 1000.0, "email");
        member.setRoles(Arrays.asList(role));
        Member savedMember = entityManager.persist(member);

        // create session
        Session session = new Session("10:00", "12:00");
        Session session2 = new Session("14:00", "16:00");
        // same scanner
        session.setScanner(scanner);
        session2.setScanner(scanner);

        session.addMember(member);
        session2.addMember(member);

        entityManager.persist(session);
        entityManager.persist(session2);
        entityManager.flush();

        List<Object[]> repoResult = memberRepository.getMemberAttendanceOverAccount(savedMember.getId());
        System.out.println("========= reuslt ");
        System.out.println(repoResult.size());
        assertThat(2).isEqualTo(repoResult.size());

        AccountType type = (AccountType) repoResult.get(0)[0]; // EATING
        System.out.println(type);
        if (type == AccountType.VIRTUAL_DOLLAR) {
            assertThat(0).isEqualTo((long) repoResult.get(0)[1]);
        } else {
            assertThat(2).isEqualTo((long) repoResult.get(0)[1]);
        }
    }
}