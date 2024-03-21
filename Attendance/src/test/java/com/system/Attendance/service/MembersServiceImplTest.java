//package com.system.Attendance.service;
//
//
//import com.system.Attendance.enums.AccountType;
//import com.system.Attendance.repository.MembersRepository;
//import com.system.Attendance.service.contract.MemberAttendenceOverAccount;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.TestConfiguration;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
////@ContextConfiguration(classes = {ScannerRepository.class})
////@EnableAutoConfiguration
////@EntityScan(basePackages = {"com.system.Attendance.domain"})
//@RunWith(SpringRunner.class)
//@DataJpaTest
//public class MembersServiceImplTest {
//
//    @TestConfiguration
//    static class MemberServiceImplTestContextConfiguration {
//        @Bean
//        public MemberService memberService() {
//            return new MembersServiceImpl();
//        }
//    }
//
//    @Autowired
//    private MemberService memberService;
//
//    @MockBean
//    private MembersRepository membersRepository;
//
//    @Before
//    public void setUp() {
//        List<Object[]> emptyList = new ArrayList<>();
//
//        List<Object[]> list2 = new ArrayList<>();
//        list2.add(new Object[]{AccountType.EATING, 10});
//        list2.add(new Object[]{AccountType.ATTENDANCE, 10});
//        Mockito.when(membersRepository.getMemberAttendanceOverAccount(5)).thenReturn(emptyList);
//        Mockito.when(membersRepository.getMemberAttendanceOverAccount(10)).thenReturn(list2);
//    }
//    @Test
//    public void getEmptyMemberAttendanceOverAccount() {
//        List<MemberAttendenceOverAccount> expected = new ArrayList<>();
//        List<MemberAttendenceOverAccount> result = memberService.getMemberAttendanceOverAccount(5);
//        assertThat(result.size()).isEqualTo(0);
//    }
//
//    @Test
//    public void getMemberAttendanceOverAccount_WithTwoAccount() {
//        List<MemberAttendenceOverAccount> result = memberService.getMemberAttendanceOverAccount(10);
//        assertThat(result.size()).isEqualTo(2);
//        assertThat(result.get(0).getAccountType()).isEqualTo(AccountType.EATING);
//        assertThat(result.get(0).getCount()).isEqualTo(10);
//        assertThat(result.get(1).getAccountType()).isEqualTo(AccountType.ATTENDANCE);
//        assertThat(result.get(1).getCount()).isEqualTo(10);
//    }
//}