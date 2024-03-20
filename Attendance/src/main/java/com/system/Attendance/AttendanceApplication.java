package com.system.Attendance;

import com.system.Attendance.integrate.MyGenerateData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "edu.miu.common, com.system.Attendance")
public class AttendanceApplication implements CommandLineRunner {

	@Autowired
	MyGenerateData generateData;
//	@Autowired
//	MembersRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		generateData.generateData();
//		//memberRepository.getMemberData(5).forEach(System.out::println);
//		System.out.println("============  value ");
//		List<Object[]> result = memberRepository.getMemberAttendanceOverAccount(5);
//		//System.out.println(memberRepository.getMemberAttendanceOverAccount(5));
//		for(int i = 0; i< result.size(); i ++) {
//			System.out.println(result.get(i)[0] + "      " + result.get(i)[1]);
//			//System.out.println(result.get(1)[0] + "      " + result.get(0)[1]);
//		}


	}

}
