package com.system.Attendance.service;

import com.system.Attendance.domain.Member;
import com.system.Attendance.domain.Scanner;
import com.system.Attendance.domain.Session;
import com.system.Attendance.repository.MembersRepository;
import com.system.Attendance.repository.ScannerRepository;
import com.system.Attendance.repository.SessionRepository;
import com.system.Attendance.service.contract.MembersPayload;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class ScannerServiceImplTest {

    @Mock
    private ScannerRepository scannerRepository;

    @Mock
    private MembersRepository membersRepository;

    @Mock
    private SessionRepository sessionRepository;

    @InjectMocks
    private ScannerServiceImpl scannerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Captor
    private ArgumentCaptor<Session> sessionCaptor;

    @Test
    public void testFetchScannerRecords() {
        Integer scannerCode = 1;
        Scanner scanner = new Scanner();
        Session session = new Session();
        Member member = new Member();
        member.setName("John");
        member.setLastName("Doe");
        member.setEmail("john.doe@example.com");
        session.setMemberList(Collections.singletonList(member));
        scanner.setSessions(Collections.singletonList(session));
        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.of(scanner));

        List<MembersPayload> result = scannerService.fetchScannerRecords(scannerCode);

        assertEquals(1, result.size());
        MembersPayload payload = result.get(0);
        assertEquals("John", payload.getFirstName());
        assertEquals("Doe", payload.getLastName());
        assertEquals("john.doe@example.com", payload.getEmail());
    }

    @Test
    public void testCreateScanRecord() {
        // Mocking scanner repository response
        Scanner mockScanner = new Scanner();
        mockScanner.setId(1L); // Assuming scanner ID is set correctly
        List<Session> sessions = new ArrayList<>();
        Session mockSession = new Session();
        mockSession.setId(1L); // Assuming session ID is set correctly
        sessions.add(mockSession);
        mockScanner.setSessions(sessions);
        when(scannerRepository.findById(1)).thenReturn(Optional.of(mockScanner));

        // Mocking members repository response
        Member mockMember = new Member();
        mockMember.setId(1L); // Assuming member ID is set correctly
        when(membersRepository.findById(1)).thenReturn(Optional.of(mockMember));

        // Test data setup
        MembersPayload payload = new MembersPayload();
        payload.setId(1); // Assuming member ID is set correctly
        payload.setSessionId(1L); // Assuming session ID is set correctly

        // Call the method under test
        scannerService.createScanRecord(payload, 1);

        // Verify interactions
        verify(scannerRepository).findById(1);
        verify(membersRepository).findById(1);
        verify(sessionRepository).save(any(Session.class)); // Verifying sessionRepository.save is called
    }


    @Test
    public void testDeleteScanRecord() {
        // Mock data setup
        Integer scannerCode = 1;
        Scanner scanner = new Scanner();
        Session session = new Session();
        session.setMemberList(new ArrayList<>());
        List<Session> sessions = Collections.singletonList(session);
        scanner.setSessions(sessions);

        // Mock repository responses
        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.of(scanner));

        // Call the method under test
        scannerService.deleteScanRecord(scannerCode);

        // Verify interactions
        verify(scannerRepository, times(1)).findById(scannerCode);
        verify(scannerRepository, times(1)).save(scanner);

        // Additional verification can be done if needed
    }

//    @Test
//    public void testUpdateScanRecord_Success() {
//        // Mock data setup
//        Integer scannerCode = 1;
//        MembersPayload membersPayload = new MembersPayload();
//        membersPayload.setId(1);
//        membersPayload.setFirstName("John");
//        membersPayload.setLastName("Doe");
//        membersPayload.setEmail("john.doe@example.com");
//
//        Scanner scanner = new Scanner();
//        Session session = new Session();
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("Jane");
//        member.setLastName("Doe");
//        member.setEmail("jane.doe@example.com");
//        session.setMemberList(Collections.singletonList(member));
//        scanner.setSessions(Collections.singletonList(session));
//        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.of(scanner));
//        when(membersRepository.save(any(Member.class))).thenReturn(member);
//
//        // Call the method under test
//        MembersPayload result = scannerService.updateScanRecord(scannerCode, membersPayload);
//
//        // Verify the update
//        assertNotNull(String.valueOf(result), "Result should not be null");
//        assertEquals("John", result.getFirstName(), "First name should be updated");
//        assertEquals("Doe", result.getLastName(), "Last name should remain unchanged");
//        assertEquals("john.doe@example.com", result.getEmail(), "Email should remain unchanged");
//    }
    @Test
    public void testUpdateScanRecord_ScannerNotFound() {
        // Mock data setup
        Integer scannerCode = 1;
        MembersPayload membersPayload = new MembersPayload();
        membersPayload.setId(1);
        membersPayload.setFirstName("John");
        membersPayload.setLastName("Doe");
        membersPayload.setEmail("john.doe@example.com");

        // Mock repository behavior (Scanner not found)
        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.empty());

        // Call the method under test
        MembersPayload result = scannerService.updateScanRecord(scannerCode, membersPayload);

        // Verify that the result is null when scanner is not found
        assertNull(result);

        // Verify that membersRepository.save() is not called
        verifyNoInteractions(membersRepository);
    }


//    @Test
//    public void testFetchScanRecord_Success() {
//        // Mock data setup
//        Integer scannerCode = 1;
//        Integer memberId = 1;
//
//        // Create member
//        Member member = new Member();
//        member.setId(1L);
//        member.setName("John");
//        member.setLastName("Doe");
//        member.setEmail("john.doe@example.com");
//
//        // Create session with member
//        Session session = new Session();
//        session.setMemberList(Collections.singletonList(member));
//
//        // Create scanner with session
//        Scanner scanner = new Scanner();
//        scanner.setSessions(Collections.singletonList(session));
//
//        // Mock repository behavior
//        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.of(scanner));
//
//        // Call the method under test
//        MembersPayload result = scannerService.fetchScanRecord(scannerCode, memberId);
//
//        // Verify the result
//        assertEquals("John", result.getFirstName(), "First name should match the member's name");
//        assertEquals("Doe", result.getLastName(), "Last name should match the member's last name");
//        assertEquals("john.doe@example.com", result.getEmail(), "Email should match the member's email");
//    }

    @Test
    public void testFetchScanRecord_MemberNotFound() {
        // Mock data setup
        Integer scannerCode = 1;
        Integer memberId = 2; // ID of a non-existing member

        Member member = new Member();
        member.setId(1L);
        member.setName("John");
        member.setLastName("Doe");
        member.setEmail("john.doe@example.com");

        Session session = new Session();
        session.setMemberList(Collections.singletonList(member));

        Scanner scanner = new Scanner();
        scanner.setSessions(Collections.singletonList(session));

        // Mock repository behavior
        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.of(scanner));

        // Call the method under test
        MembersPayload result = scannerService.fetchScanRecord(scannerCode, memberId);

        // Verify that the result is null when member is not found
        assertNull("Result should be null when member is not found", result);
    }


    @Test
    public void testFetchScanRecord_EmptySessions() {
        // Mock data setup
        Integer scannerCode = 1;
        Integer memberId = 1;

        Scanner scanner = new Scanner();
        scanner.setSessions(new ArrayList<>()); // Empty sessions list

        // Mock repository behavior
        when(scannerRepository.findById(scannerCode)).thenReturn(Optional.of(scanner));

        // Call the method under test
        MembersPayload result = scannerService.fetchScanRecord(scannerCode, memberId);

        // Verify that the result is null when sessions are empty
        assertNull("Result should be null when sessions are empty", result);
    }


}
