package com.system.Attendance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//(scanBasePackages = "edu.miu.common, com.system.Attendance")
public class AttendanceApplication implements CommandLineRunner {

//	@Autowired
   // MyGenerateData generateData;
//	@Autowired
//	MemberRepository memberRepository;

	public static void main(String[] args) {
		SpringApplication.run(AttendanceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	generateData.generateData();
		//memberRepository.getMemberData(5).forEach(System.out::println);
	}

}
